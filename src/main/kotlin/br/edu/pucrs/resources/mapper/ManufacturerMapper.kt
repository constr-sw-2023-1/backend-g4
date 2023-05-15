package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.dto.response.ManufacturerResponseDTO

class ManufacturerMapper {
    companion object {
        fun toResponse(manufacturer: Manufacturer): ManufacturerResponseDTO {
<<<<<<< HEAD
            var manufacturerResponseDTO = ManufacturerResponseDTO(manufacturer._id!!, manufacturer.name!!)
=======
            var manufacturerResponseDTO = ManufacturerResponseDTO()
            manufacturerResponseDTO._id = manufacturer._id
            manufacturerResponseDTO.name = manufacturer.name
>>>>>>> 68c771612413638cd237879cfa499dda6513ef40

            return manufacturerResponseDTO
        }
    }
}