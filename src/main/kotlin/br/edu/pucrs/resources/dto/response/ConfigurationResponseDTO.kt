package br.edu.pucrs.resources.dto.response

import java.util.*

data class ConfigurationResponseDTO (
        var id: UUID,
        var component: String,
        var description: String,
)