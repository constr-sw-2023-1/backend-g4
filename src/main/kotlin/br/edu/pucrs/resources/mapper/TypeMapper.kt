package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.response.TypeResponseDTO

class TypeMapper {
    companion object {
        fun toResponse(type: Type):TypeResponseDTO {
<<<<<<< HEAD
            var typeResponseDTO = TypeResponseDTO(type._id!!, type.name!!)
=======
            var typeResponseDTO = TypeResponseDTO()
            typeResponseDTO._id = type._id
            typeResponseDTO.name = type.name
>>>>>>> 68c771612413638cd237879cfa499dda6513ef40

            return typeResponseDTO
        }
    }
}