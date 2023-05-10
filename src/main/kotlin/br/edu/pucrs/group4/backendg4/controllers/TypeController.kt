package br.edu.pucrs.group4.backendg4.controllers

import br.edu.pucrs.group4.backendg4.entities.Type
import br.edu.pucrs.group4.backendg4.services.TypeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/types")
class TypeController(private val typeService: TypeService) {

    @GetMapping
    fun getAllTypes(): ResponseEntity<List<Type>> {
        val types = typeService.getAllTypes()
        return ResponseEntity.ok(types)
    }

    @GetMapping("/{id}")
    fun getTypeById(@PathVariable id: UUID): ResponseEntity<Type> {
        val type = typeService.getTypeById(id)
        return ResponseEntity.ok(type)
    }

    @PostMapping
    fun createType(@RequestBody type: Type): ResponseEntity<Type> {
        val createdType = typeService.createType(type)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType)
    }

}
