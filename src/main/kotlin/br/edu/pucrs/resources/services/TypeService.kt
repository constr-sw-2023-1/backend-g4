package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.exceptions.NotFoundException
import br.edu.pucrs.resources.repositories.TypeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeService(private val typeRepository: TypeRepository) {

    fun save(type: Type): Type {
        return typeRepository.save(type)
    }

    fun findAll(): List<Type> {
        return typeRepository.findAll()
    }

    fun findById(id: UUID): Type {
        return typeRepository.findById(id)
                .orElseThrow { NotFoundException(message = "Type not found with ID: $id") }
    }

    fun findByName(name: String): List<Type> {
        return typeRepository.findByName(name)
    }

    fun findByNameLike(name: String): List<Type> {
        return typeRepository.findByNameLike(name)
    }

    fun update(newType: Type): Type {
        findById(newType.id!!)
        return typeRepository.save(newType)
    }

    fun deleteById(id: UUID) {
        findById(id)
        return typeRepository.deleteById(id)
    }

    fun updatePatch(newType: Type): Type {
        findById(newType.id!!)
        return typeRepository.save(newType)
    }

}
