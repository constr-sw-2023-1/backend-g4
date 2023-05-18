package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO

class ConfigurationMapper {
    companion object {
        fun toResponse(configuration: Configuration): ConfigurationResponseDTO {
            return ConfigurationResponseDTO(configuration.id!!, configuration.component!!, configuration.description!!)
        }
    }
}