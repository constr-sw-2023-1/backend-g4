package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.domain.VO.Configuration
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.mapper.ConfigurationMapper
import br.edu.pucrs.resources.mapper.ResourceMapper
import br.edu.pucrs.resources.repositories.ResourceRepository
import br.edu.pucrs.resources.repositories.ResourceRepositoryImpl
import org.springframework.stereotype.Service
import java.util.*

@Service
class ResourceService(private val resourceRepository: ResourceRepository,
        private val typeService: TypeService,
        private val manufacturerService: ManufacturerService,
        private val resourceRepositoryImpl: ResourceRepositoryImpl) {

    fun save(resource: ResourceRequestDTO): ResourceResponseDTO {
        val type = typeService.findById(resource.typeUUID)
        val manufacturer = manufacturerService.findById(resource.manufacturerUUID)
        val configurations = resource.configurations.map { ConfigurationMapper.toEntity(it) } as ArrayList<Configuration>

        val resourceEntity = ResourceMapper.toEntity(resource, type, manufacturer, configurations)

        return ResourceMapper.toResponse(resourceRepository.save(resourceEntity))
    }

    fun findAll(): List<Resource> {
        return resourceRepository.findAll()
    }

    fun findById(id: UUID): Resource {
        return resourceRepository.findById(id).orElseThrow { NotFoundException(message = "Resource not found with ID: $id", errors = listOf("[Resources API] Resource not found with ID: $id")) }
    }

    fun update(newResource: Resource): Resource {
        findById(newResource.id!!)
        return resourceRepository.save(newResource)
    }

    fun deleteById(id: UUID) {
        findById(id)
        return resourceRepository.deleteById(id)
    }

    fun findByDescriptionLike(description: String) : List<Resource> {
        return resourceRepository.findByDescriptionLike(description)
    }

    fun updatePatch(newResource: Resource): Resource {
        findById(newResource.id!!)
        return resourceRepository.save(newResource)
    }

    fun findAllByComplexQuery(params: Map<String, String>): List<ResourceResponseDTO> {
        return resourceRepositoryImpl.findAllByComplexQuery(params).map {
            ResourceMapper.toResponse(it)
        }
    }
}
