package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.dto.response.ManufacturerResponseDTO

class ManufacturerMapper {
    companion object {
        fun toResponse(manufacturer: Manufacturer): ManufacturerResponseDTO {
            var manufacturerResponseDTO = ManufacturerResponseDTO()
            manufacturerResponseDTO._id = manufacturer._id
            manufacturerResponseDTO.name = manufacturer.name

            return manufacturerResponseDTO
        }
    }
}