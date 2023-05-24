package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Manufacturer
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

@Tag(name = "Resources API", description = "Endpoints for Resources API")
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

    @Operation(summary = "Get all resources by description")
    @GetMapping("/description/{description}")
    fun findByDescriptionLike(@PathVariable description: String): List<Resource> {
        return resourceService.findByDescriptionLike(description)
    }

    @Operation(summary = "Update resource")
    @PatchMapping
    fun updatePatch(@RequestBody resource: Resource): ResponseEntity<Resource> {
        val resource = resourceService.updatePatch(resource)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Get all resources by complex query")
    @GetMapping("/complex-query")
    fun findAllByComplexQuery(@RequestParam params: Map<String, String>): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(this.resourceService.findAllByComplexQuery(params))
    }

    @Operation(summary = "Get all resources by type")
    @GetMapping("/type/{type}")
    fun findAllByType(
            @PathVariable type: String,
    ): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(this.resourceService.findAllByType(type))
    }

    @Operation(summary = "Get all resources by manufacturer")
    @GetMapping("/manufacturer/{manufacturer}")
    fun findAllByManufacturer(
            @PathVariable manufacturer: String
    ): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(this.resourceService.findAllByManufacturer(manufacturer))
    }

}
