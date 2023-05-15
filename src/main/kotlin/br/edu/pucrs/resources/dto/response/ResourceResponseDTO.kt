package br.edu.pucrs.resources.dto.response

import java.util.*

data class ResourceResponseDTO (
        var id: UUID,
        var description: String,
        var type: TypeResponseDTO,
        var manufacturer: ManufacturerResponseDTO,
        var configurations: ArrayList<ConfigurationResponseDTO> = arrayListOf()
)
