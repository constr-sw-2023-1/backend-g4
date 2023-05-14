package br.edu.pucrs.resources.dto.response

import java.util.*

class ResourceResponseDTO {
    var _id: UUID? = null
    var description: String? = null
    var type: TypeResponseDTO? = null
    var manufacturer: ManufacturerResponseDTO? = null
    var configurations: ArrayList<ConfigurationResponseDTO> = arrayListOf()
}