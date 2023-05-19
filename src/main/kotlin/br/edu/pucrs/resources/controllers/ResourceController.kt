package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.response.ResourceResponseDTO
import br.edu.pucrs.resources.services.ResourceService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Resources API", description = "endpoints resource api")
@RestController
@RequestMapping("/resources")
class ResourceController(private val resourceService: ResourceService) {

    @Operation(summary = "Create a new resource")
    @PostMapping
    fun save(@RequestBody resource: ResourceRequestDTO): ResponseEntity<ResourceResponseDTO> {
        val createdResource =  resourceService.save(resource)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource)
    }

    @Operation(summary = "Get all resources")
    @GetMapping
    fun findAll(): ResponseEntity<List<Resource>> {
        val resources = resourceService.findAll()
        return ResponseEntity.ok(resources)
    }

    @Operation(summary = "Get resource by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Resource> {
        val resource = resourceService.findById(id)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Update resource")
    @PutMapping
    fun update(@RequestBody resource: Resource): ResponseEntity<Resource> {
        val resource = resourceService.update(resource)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Delete resource")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return resourceService.deleteById(id)
    }

    @Operation(summary = "Get resource by part of name")
    @GetMapping("/findByNameLike/{description}")
    fun findByDescriptionLike(@PathVariable description: String): List<Resource> {
        return resourceService.findByDescriptionLike(description)
    }

    @Operation(summary = "Update resource")
    @PatchMapping
    fun updatePatch(@RequestBody resource: Resource): ResponseEntity<Resource> {
        val resource = resourceService.updatePatch(resource)
        return ResponseEntity.ok(resource)
    }

    @GetMapping("/complex-query")
    fun findAllByComplexQuery(@RequestParam params: Map<String, String>): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(this.resourceService.findAllByComplexQuery(params))
    }

}
