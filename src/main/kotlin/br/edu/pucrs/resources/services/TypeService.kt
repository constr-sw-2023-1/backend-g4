package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.entities.Type
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
import br.edu.pucrs.resources.repositories.TypeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeService(private val typeRepository: TypeRepository) {

    fun getAllTypes(): List<Type> {
        return typeRepository.findAll()
    }

    fun getTypeById(id: UUID): Type {
        return typeRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("Type not found with id $id") }
    }

    fun createType(type: Type): Type {
        return typeRepository.save(type)
    }
}
