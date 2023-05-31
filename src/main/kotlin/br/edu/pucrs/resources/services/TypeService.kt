package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.request.TypeDTO
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.exceptions.RequestValidationException
import br.edu.pucrs.resources.repositories.TypeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeService(private val typeRepository: TypeRepository) {

    fun save(type: Type): Type {
        return typeRepository.save(type)
    }

    fun findAll(): List<Type> {
        return typeRepository.findAll().filter { t -> t.active }
    }

    fun findById(id: UUID): Type {
        return typeRepository.findById(id).filter { t -> t.active }
            .orElseThrow { NotFoundException(message = "Type not found with ID: $id") }
    }

    fun findByName(name: String): List<Type> {
        return typeRepository.findByName(name)
    }

    fun findByNameLike(name: String): List<Type> {
        return typeRepository.findByNameLike(name)
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
