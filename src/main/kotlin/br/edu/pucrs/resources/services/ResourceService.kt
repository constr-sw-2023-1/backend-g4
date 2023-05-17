package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
import br.edu.pucrs.resources.mapper.ResourceMapper
import br.edu.pucrs.resources.repositories.ResourceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ResourceService(private val resourceRepository: ResourceRepository,
        private val typeService: TypeService,
        private val manufacturerService: ManufacturerService,
        private val configurationService: ConfigurationService) {

    fun save(resource: ResourceRequestDTO): ResourceResponseDTO {
        val type = typeService.findById(resource.typeUUID!!)
        val manufacturer = manufacturerService.findById(resource.manufacturerUUID!!)
        val configurations = configurationService.findAllByConfigurationsUUID(resource.configurationsUUID)

        val resourceEntity = ResourceMapper.toEntity(resource, type, manufacturer, configurations)

        return ResourceMapper.toResponse(resourceRepository.save(resourceEntity))
    }

    fun findAll(): List<Resource> {
        return resourceRepository.findAll()
    }

    fun findById(id: UUID): Resource {
        return resourceRepository.findById(id).orElseThrow { ResourceNotFoundException("Recurso não encontrado") }
    }

    fun update(newResource: Resource): Resource {
        findById(newResource._id!!)
        return resourceRepository.save(newResource)
    }

    fun deleteById(id: UUID) {
        findById(id)
        return resourceRepository.deleteById(id)
    }
}
