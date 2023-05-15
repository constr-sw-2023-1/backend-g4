package br.edu.pucrs.resources.mapper

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.response.TypeResponseDTO

class TypeMapper {
    companion object {
        fun toResponse(type: Type):TypeResponseDTO {
            var typeResponseDTO = TypeResponseDTO(type._id!!, type.name!!)

            return typeResponseDTO
        }
    }
}