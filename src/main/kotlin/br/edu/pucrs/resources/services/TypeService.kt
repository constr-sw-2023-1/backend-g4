package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
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
                .orElseThrow { ResourceNotFoundException("Type not found with id $id") }
    }

    fun findByName(name: String): Type {
        return typeRepository.findByName(name)
    }

    fun update(newType: Type): Type {
        findById(newType._id!!)
        return typeRepository.save(newType)
    }

    fun deleteById(id: UUID) {
        findById(id)
        return typeRepository.deleteById(id)
    }
}
