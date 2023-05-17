package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.services.ResourceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/resources")
class ResourceController(private val resourceService: ResourceService) {

    @PostMapping
    fun save(@RequestBody resource: ResourceRequestDTO): ResponseEntity<ResourceResponseDTO> {
        val createdResource =  resourceService.save(resource)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Resource>> {
        val resources = resourceService.findAll()
        return ResponseEntity.ok(resources)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Resource> {
        val resource = resourceService.findById(id)
        return ResponseEntity.ok(resource)
    }

    @PutMapping
    fun update(@RequestBody resource: Resource): ResponseEntity<Resource> {
        val resource = resourceService.update(resource)
        return ResponseEntity.ok(resource)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return resourceService.deleteById(id)
    }

}
