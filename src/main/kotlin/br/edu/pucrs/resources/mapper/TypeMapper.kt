package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.response.TypeResponseDTO

class TypeMapper {
    companion object {
        fun toResponse(type: Type):TypeResponseDTO {
            var typeResponseDTO = TypeResponseDTO()
            typeResponseDTO._id = type._id
            typeResponseDTO.name = type.name

            return typeResponseDTO
        }
    }
}