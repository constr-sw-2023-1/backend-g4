package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.entities.Resource
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
import br.edu.pucrs.resources.repositories.ResourceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ResourceService(private val resourceRepository: ResourceRepository) {

    fun save(resource: Resource): Resource {
        return resourceRepository.save(resource)
    }

    fun findAll(): List<Resource> {
        return resourceRepository.findAll()
    }

    fun findById(id: UUID): Resource {
        return resourceRepository.findById(id).orElseThrow { ResourceNotFoundException("Recurso não encontrado") }
    }

    fun update(id: UUID, novoRecurso: Resource): Resource {
        val recursoExistente = findById(id)

//        recursoExistente.descricao = novoRecurso.descricao
//        recursoExistente.tipo = novoRecurso.tipo
//        recursoExistente.fabricante = novoRecurso.fabricante

        return resourceRepository.save(recursoExistente)
    }
}
