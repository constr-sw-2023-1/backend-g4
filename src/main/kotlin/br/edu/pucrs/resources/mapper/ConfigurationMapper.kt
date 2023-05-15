package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO

class ConfigurationMapper {
    companion object {
        fun toResponse(configuration: Configuration): ConfigurationResponseDTO {
<<<<<<< HEAD
            var configurationResponseDTO = ConfigurationResponseDTO(configuration._id!!, configuration.component!!, configuration.description!!)
=======
            var configurationResponseDTO = ConfigurationResponseDTO()

            configurationResponseDTO._id = configuration._id
            configurationResponseDTO.component = configuration.component
            configurationResponseDTO.description = configuration.description
>>>>>>> 68c771612413638cd237879cfa499dda6513ef40

            return configurationResponseDTO
        }
    }
}