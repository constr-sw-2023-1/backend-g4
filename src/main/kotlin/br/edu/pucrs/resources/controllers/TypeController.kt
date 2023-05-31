package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Type
import br.edu.pucrs.resources.dto.request.TypeDTO
import br.edu.pucrs.resources.dto.response.TypeResponseDTO
import br.edu.pucrs.resources.services.TypeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Types API", description = "Endpoints for Types API")
@RestController
@RequestMapping("/resources/types")
class TypeController(private val typeService: TypeService) {

    @Operation(summary = "Create a new type")
    @PostMapping
    fun save(@RequestBody type: Type): ResponseEntity<Type> {
        val createdType = typeService.save(type)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType)
    }

    @Operation(summary = "Get all types")
    @GetMapping
    fun findAllByComplexQuery(@RequestParam(defaultValue = "{}") params: Map<String, String>): ResponseEntity<List<TypeResponseDTO>> {
        val types = typeService.findAllByComplexQuery(params)
        return ResponseEntity.ok(types)
    }

    @Operation(summary = "Get type by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Type> {
        val type = typeService.findById(id)
        return ResponseEntity.ok(type)
    }

    @Operation(summary = "Update type")
    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody type: TypeDTO): ResponseEntity<Type> {
        val resource = typeService.update(id, type)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Update type")
    @PatchMapping("/{id}")
    fun updatePatch(@PathVariable id: UUID, @RequestBody type: TypeDTO): ResponseEntity<Type> {
        val resource = typeService.updateName(id, type)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Delete type")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return typeService.deleteById(id)
    }

}
