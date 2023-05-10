package br.edu.pucrs.group4.backendg4.services

import br.edu.pucrs.group4.backendg4.entities.Resource
import br.edu.pucrs.group4.backendg4.exceptions.ResourceNotFoundException
import br.edu.pucrs.group4.backendg4.repositories.ResourceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ResourceService(private val resourceRepository: ResourceRepository) {

    fun cadastrarRecurso(recurso: Resource): Resource {
        if (recurso.id == null) {
            recurso.id = UUID.randomUUID()
        }
        return resourceRepository.save(recurso)
    }

    fun listarRecursos(): List<Resource> {
        return resourceRepository.findAll()
    }

    fun buscarRecursoPorId(id: UUID): Resource {
        return resourceRepository.findById(id).orElseThrow { ResourceNotFoundException("Recurso não encontrado") }
    }

    fun atualizarRecurso(id: UUID, novoRecurso: Resource): Resource {
        val recursoExistente = buscarRecursoPorId(id)

        recursoExistente.descricao = novoRecurso.descricao
        recursoExistente.tipo = novoRecurso.tipo
        recursoExistente.fabricante = novoRecurso.fabricante

        return resourceRepository.save(recursoExistente)
    }
}
