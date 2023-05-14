package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO

class ResourceMapper {
    companion object {

        fun toResponse(resource: Resource): ResourceResponseDTO {
            var resourceResponseDTO = ResourceResponseDTO()

            resourceResponseDTO._id = resource._id
            resourceResponseDTO.description = resource.description
            resourceResponseDTO.type = TypeMapper.toResponse(resource.type!!)
            resourceResponseDTO.manufacturer = ManufacturerMapper.toResponse(resource.manufacturer!!)
            resourceResponseDTO.configurations = resource.configuration.map {
                ConfigurationMapper.toResponse(it)
            } as ArrayList<ConfigurationResponseDTO>

            return resourceResponseDTO
        }

        fun toEntity(resource: ResourceRequestDTO, type: Type, manufacturer: Manufacturer, configurations: ArrayList<Configuration>): Resource {
            var resourceEntity = Resource()

            resourceEntity.description = resource.description
            resourceEntity.type = type
            resourceEntity.manufacturer = manufacturer
            resourceEntity.configuration = configurations

            return resourceEntity
        }
    }

}