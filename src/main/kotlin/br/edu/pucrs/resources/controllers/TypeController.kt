package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.entities.Type
import br.edu.pucrs.resources.services.TypeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/types")
class TypeController(private val typeService: TypeService) {

    @PostMapping
    fun save(@RequestBody type: Type): ResponseEntity<Type> {
        val createdType = typeService.save(type)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Type>> {
        val types = typeService.findAll()
        return ResponseEntity.ok(types)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<Type> {
        val type = typeService.findById(id)
        return ResponseEntity.ok(type)
    }
}
