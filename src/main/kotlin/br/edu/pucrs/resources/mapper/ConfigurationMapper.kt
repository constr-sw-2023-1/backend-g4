package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.dto.request.ConfigurationRequestDTO
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO

class ConfigurationMapper {
    companion object {
        fun toResponse(configuration: Configuration): ConfigurationResponseDTO {
            return ConfigurationResponseDTO(configuration.component!!, configuration.description!!)
        }

        fun toEntity(configuration: ConfigurationRequestDTO): Configuration {
            val configurationEntity = Configuration()

            configurationEntity.component = configuration.component
            configurationEntity.description = configuration.description

            return configurationEntity
        }
    }
}