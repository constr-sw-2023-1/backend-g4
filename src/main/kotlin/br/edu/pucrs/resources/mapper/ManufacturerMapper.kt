package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.dto.response.ManufacturerResponseDTO

class ManufacturerMapper {
    companion object {
        fun toResponse(manufacturer: Manufacturer): ManufacturerResponseDTO {
            return ManufacturerResponseDTO(manufacturer.id!!, manufacturer.name!!)
        }
    }
}