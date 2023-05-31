package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.VO.Configuration
import br.edu.pucrs.resources.dto.request.ConfigurationRequestDTO
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.mapper.ConfigurationMapper
import br.edu.pucrs.resources.repositories.ResourceRepository
import br.edu.pucrs.resources.repositories.ResourceRepositoryImpl
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class ConfigurationService(private val resourceRepository: ResourceRepository,
                           private val resourceService: ResourceService,
                           private val resourceRepositoryImpl: ResourceRepositoryImpl) {

    fun save(id: UUID, configuration: List<ConfigurationRequestDTO>): List<ConfigurationResponseDTO> {

        val resource = resourceService.findById(id)
        val configurations = configuration.map { ConfigurationMapper.toEntity(it) } as ArrayList<Configuration>

        resource.configurations = configurations;

        val response = resourceRepository.save(resource).configurations

        return response.map { ConfigurationMapper.toResponse(it) }

    }

    fun findById(id: UUID): List<Configuration> {
        val response = resourceRepository.findById(id).orElseThrow { NotFoundException(message = "Resource not found with ID: $id") }
        return response.configurations;
    }

    fun update(id: UUID, configuration: List<ConfigurationRequestDTO>): List<ConfigurationResponseDTO> {

        val resource = resourceService.findById(id)
        val configurations = configuration.map { ConfigurationMapper.toEntity(it) } as ArrayList<Configuration>

        val newResources = resource.configurations.toMutableSet()

        newResources.addAll(configurations)

        resource.configurations = ArrayList(newResources)

        val response = resourceRepository.save(resource).configurations

        return response.map { ConfigurationMapper.toResponse(it) }

    }

    fun deleteById(id: UUID) {
        val resource = resourceService.findById(id)
        resource.configurations = emptyList();

        resourceRepository.save(resource)
    }

}
