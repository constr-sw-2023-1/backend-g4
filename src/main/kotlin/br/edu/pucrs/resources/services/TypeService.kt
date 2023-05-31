package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.request.TypeDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.dto.response.TypeResponseDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.exceptions.RequestValidationException
import br.edu.pucrs.resources.mapper.ResourceMapper
import br.edu.pucrs.resources.mapper.TypeMapper
import br.edu.pucrs.resources.repositories.TypeRepository
import br.edu.pucrs.resources.repositories.TypeRepositoryImpl
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeService(private val typeRepository: TypeRepository, private val typeRepositoryImpl: TypeRepositoryImpl) {

    fun save(type: Type): Type {
        return typeRepository.save(type)
    }

    fun findAllByComplexQuery(params: Map<String, String>): List<TypeResponseDTO> {
        return typeRepositoryImpl.findAllByComplexQuery(params).filter { it.active }.map {
            TypeMapper.toResponse(it)
        }
    }

    fun findById(id: UUID): Type {
        return typeRepository.findById(id).filter { t -> t.active }
            .orElseThrow { NotFoundException(message = "Type not found with ID: $id") }
    }

    fun update(id: UUID, newType: TypeDTO): Type {
        val typeToUpdate = findById(id)

        if (newType.name == null) {
            throw RequestValidationException("Name cannot be null")
        }
        typeToUpdate.name = newType.name

        return typeRepository.save(typeToUpdate)
    }

    fun updateName(id: UUID, newType: TypeDTO): Type {
        val typeToUpdate = findById(id)

        typeToUpdate.name = newType.name ?: typeToUpdate.name
        return typeRepository.save(typeToUpdate)
    }

    fun deleteById(id: UUID) {
        val type = findById(id)
        type.active = false
        typeRepository.save(type)
    }

}
