package br.edu.pucrs.group4.backendg4.controllers

import br.edu.pucrs.group4.backendg4.entities.Resource
import br.edu.pucrs.group4.backendg4.services.ResourceService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/resources")
class ResourceController(private val resourceService: ResourceService) {

    @PostMapping
    fun cadastrarRecurso(@RequestBody recurso: Resource): Resource {
        return resourceService.cadastrarRecurso(recurso)
    }

    @GetMapping
    fun listarRecursos(): List<Resource> {
        return resourceService.listarRecursos()
    }

    @GetMapping("/{id}")
    fun buscarRecursoPorId(@PathVariable id: UUID): Resource {
        return resourceService.buscarRecursoPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizarRecurso(@PathVariable id: UUID, @RequestBody recurso: Resource): Resource {
        return resourceService.atualizarRecurso(id, recurso)
    }

}
