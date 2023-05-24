package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Type
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

    @Operation(summary = "Crate a new resource")
    @PostMapping
    fun save(@RequestBody type: Type): ResponseEntity<Type> {
        val createdType = typeService.save(type)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType)
    }

    @Operation(summary = "Get all types")
    @GetMapping
    fun findAll(): ResponseEntity<List<Type>> {
        val types = typeService.findAll()
        return ResponseEntity.ok(types)
    }

    @Operation(summary = "Get type by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Type> {
        val type = typeService.findById(id)
        return ResponseEntity.ok(type)
    }

    @Operation(summary = "Get type by name")
    @GetMapping("/findByName/{name}")
    fun findByName(@PathVariable name: String): List<Type> {
        return typeService.findByName(name)
    }

    @Operation(summary = "Get type by part of name")
    @GetMapping("/findByNameLike/{name}")
    fun findByNameLike(@PathVariable name: String): List<Type> {
        return typeService.findByNameLike(name)
    }

    @Operation(summary = "Update type")
    @PutMapping
    fun update(@RequestBody type: Type): ResponseEntity<Type> {
        val resource = typeService.update(type)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Update type")
    @PatchMapping
    fun updatePatch(@RequestBody type: Type): ResponseEntity<Type> {
        val resource = typeService.updatePatch(type)
        return ResponseEntity.ok(resource)
    }

    @Operation(summary = "Delete type")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return typeService.deleteById(id)
    }

}
