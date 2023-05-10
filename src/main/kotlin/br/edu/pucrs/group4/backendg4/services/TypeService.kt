package br.edu.pucrs.group4.backendg4.services

import br.edu.pucrs.group4.backendg4.entities.Type
import br.edu.pucrs.group4.backendg4.exceptions.ResourceNotFoundException
import br.edu.pucrs.group4.backendg4.repositories.TypeRepository
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
