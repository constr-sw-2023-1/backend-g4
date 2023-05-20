package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.domain.VO.Configuration
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO

class ResourceMapper {
    companion object {
        fun toResponse(resource: Resource): ResourceResponseDTO {
            return ResourceResponseDTO(
                    resource.id!!, resource.description!!,
                    TypeMapper.toResponse(resource.type!!),
                    ManufacturerMapper.toResponse(resource.manufacturer!!),
                    resource.configurations.map {
                            ConfigurationMapper.toResponse(it)
                        } as ArrayList<ConfigurationResponseDTO>)
        }

        fun toEntity(resource: ResourceRequestDTO, type: Type, manufacturer: Manufacturer, configurations: ArrayList<Configuration>): Resource {
            var resourceEntity = Resource()

            resourceEntity.description = resource.description
            resourceEntity.type = type
            resourceEntity.manufacturer = manufacturer
            resourceEntity.configurations = configurations

            return resourceEntity
        }
    }

}