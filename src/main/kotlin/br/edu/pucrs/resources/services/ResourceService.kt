package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.domain.VO.Configuration
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.request.ResourcePatchRequestDTO
import br.edu.pucrs.resources.dto.request.ResourceUpdateRequestDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.mapper.ConfigurationMapper
import br.edu.pucrs.resources.mapper.ResourceMapper
import br.edu.pucrs.resources.repositories.ResourceRepository
import br.edu.pucrs.resources.repositories.ResourceRepositoryImpl
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Predicate

@Service
class ResourceService(
    private val resourceRepository: ResourceRepository,
    private val typeService: TypeService,
    private val manufacturerService: ManufacturerService,
    private val resourceRepositoryImpl: ResourceRepositoryImpl
) {

    fun save(resource: ResourceRequestDTO): ResourceResponseDTO {
        val type = typeService.findById(resource.typeUUID)
        val manufacturer = manufacturerService.findById(resource.manufacturerUUID)
        val configurations =
            resource.configurations.map { ConfigurationMapper.toEntity(it) } as ArrayList<Configuration>

        val resourceEntity = ResourceMapper.toEntity(resource, type, manufacturer, configurations)

        return ResourceMapper.toResponse(resourceRepository.save(resourceEntity))
    }

    fun findById(id: UUID): Resource {
        return resourceRepository.findById(id).filter { r -> r.active }
            .orElseThrow { NotFoundException(message = "Resource not found with ID: $id") }
    }

    fun update(id: UUID, newResource: ResourceUpdateRequestDTO): Resource {
        val resourceToUpdate = findById(id)

        resourceToUpdate.description = newResource.description
        resourceToUpdate.type = newResource.type
        resourceToUpdate.manufacturer = newResource.manufacturer
        resourceToUpdate.configurations = newResource.configurations!!.map { ConfigurationMapper.toEntity(it) }
        return resourceRepository.save(resourceToUpdate)
    }

    fun deleteById(id: UUID) {
        val resource = findById(id)
        resource.active = false
        resourceRepository.save(resource)
    }

    fun findByDescriptionLike(description: String): List<Resource> {
        return resourceRepository.findByDescriptionLike(description)
    }

    fun updatePatch(id: UUID, resource: ResourcePatchRequestDTO): Resource {
        val resourceToUpdate = findById(id)

        resourceToUpdate.description = resource.description ?: resourceToUpdate.description
        resourceToUpdate.type = resource.type ?: resourceToUpdate.type
        resourceToUpdate.manufacturer = resource.manufacturer ?: resourceToUpdate.manufacturer
        resourceToUpdate.configurations = resource.configurations.map { ConfigurationMapper.toEntity(it) }

        return resourceRepository.save(resourceToUpdate)
    }

    fun findAllByComplexQuery(params: Map<String, String>): List<ResourceResponseDTO> {
        return resourceRepositoryImpl.findAllByComplexQuery(params).filter { it.active }.map {
            ResourceMapper.toResponse(it)
        }
    }

    fun findAllByType(type: String): List<ResourceResponseDTO> {
        return resourceRepository.findAllByType_Name(type).filter { it.active }.map {
            ResourceMapper.toResponse(it)
        }
    }

    fun findAllByManufacturer(manufacturer: String): List<ResourceResponseDTO>? {
        return resourceRepository.findAllByManufacturer_Name(manufacturer).filter { it.active }.map {
            ResourceMapper.toResponse(it)
        }

    }

    fun findAllByConfiguration(configuration: String): List<ResourceResponseDTO>? {
        return resourceRepository.findAllByConfigurations_Component(configuration).filter { it.active }.map {
            ResourceMapper.toResponse(it)
        }

    }
}
