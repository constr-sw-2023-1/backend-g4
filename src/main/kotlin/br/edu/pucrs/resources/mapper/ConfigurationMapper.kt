package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO

class ConfigurationMapper {
    companion object {
        fun toResponse(configuration: Configuration): ConfigurationResponseDTO {
            var configurationResponseDTO = ConfigurationResponseDTO(configuration._id!!, configuration.component!!, configuration.description!!)

            return configurationResponseDTO
        }
    }
}