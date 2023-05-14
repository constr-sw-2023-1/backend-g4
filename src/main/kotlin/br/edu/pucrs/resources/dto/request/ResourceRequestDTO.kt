package br.edu.pucrs.resources.dto.request

import java.util.*

class ResourceRequestDTO {
    var description: String? = null
    var typeUUID: UUID? = null
    var manufacturerUUID: UUID? = null
    var configurationsUUID: ArrayList<UUID> = arrayListOf()
}