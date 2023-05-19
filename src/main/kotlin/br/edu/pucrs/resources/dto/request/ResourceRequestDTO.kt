package br.edu.pucrs.resources.dto.request

import java.util.*

data class ResourceRequestDTO (
        var description: String,
        var typeUUID: UUID,
        var manufacturerUUID: UUID,
        var configurations: ArrayList<ConfigurationRequestDTO> = arrayListOf()
)
