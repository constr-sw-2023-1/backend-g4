package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.services.ManufacturerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Manufacturers API", description = "endpoints manufacturer api")
@RestController
@RequestMapping("/manufacturers")
class ManufacturerController(private val manufacturerService: ManufacturerService) {


    @Operation(summary = "Create a new manufacturer")
    @PostMapping
    fun save(@RequestBody manufacturer: Manufacturer): Manufacturer {
        return manufacturerService.save(manufacturer)
    }

    @Operation(summary = "Get all manufacturers")
    @GetMapping
    fun findAll(): List<Manufacturer> {
        return manufacturerService.findAll()
    }

    @Operation(summary = "Get manufacturer by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): Manufacturer {
        return manufacturerService.findById(id)
    }

    @Operation(summary = "Update manufacturer")
    @PutMapping
    fun update(@RequestBody manufacturer: Manufacturer): Manufacturer {
        return manufacturerService.update(manufacturer)
    }

    @Operation(summary = "Delete manufacturer")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return manufacturerService.deleteById(id)
    }

}
