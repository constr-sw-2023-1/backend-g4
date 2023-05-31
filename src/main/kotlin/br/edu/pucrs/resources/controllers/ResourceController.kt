package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.dto.request.ResourcePatchRequestDTO
import br.edu.pucrs.resources.dto.request.ResourceRequestDTO
import br.edu.pucrs.resources.dto.request.ResourceUpdateRequestDTO
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
    fun findAllByComplexQuery(@RequestParam(defaultValue = "{}") params: Map<String, String>): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(resourceService.findAllByComplexQuery(params))
    }

    @Operation(summary = "Get resource by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Resource> {
        val resource = resourceService.findById(id)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Update resource")
    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody resource: ResourceUpdateRequestDTO): ResponseEntity<Resource> {
        val updatedResource = resourceService.update(id, resource)
        return ResponseEntity.ok(updatedResource)
    }

    @Operation(summary = "Update resource")
    @PatchMapping("/{id}")
    fun updatePatch(@PathVariable id: UUID, @RequestBody resource: ResourcePatchRequestDTO): ResponseEntity<Resource> {
        val updatedResource = resourceService.updatePatch(id, resource)
        return ResponseEntity.ok(updatedResource)
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

    @Operation(summary = "Get all resources by configuration")
    @GetMapping("/configuration/{configuration}")
    fun findAllByConfiguration(
        @PathVariable configuration: String
    ): ResponseEntity<List<ResourceResponseDTO>> {
        return ResponseEntity.ok(this.resourceService.findAllByConfiguration(configuration))
    }

}
