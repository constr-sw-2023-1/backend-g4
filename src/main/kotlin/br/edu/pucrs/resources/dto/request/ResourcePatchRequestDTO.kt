package br.edu.pucrs.resources.dto.request

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.domain.Type

data class ResourcePatchRequestDTO(
    var description: String?,
    var type: Type?,
    var manufacturer: Manufacturer?,
    var configurations: ArrayList<ConfigurationRequestDTO> = arrayListOf()
)
