package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.dto.request.ManufacturerUpdateDTO
import br.edu.pucrs.resources.dto.response.ManufacturerResponseDTO
import br.edu.pucrs.resources.services.ManufacturerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Manufacturers API", description = "Endpoints for Manufacturers API")
@RestController
@RequestMapping("/resources/manufacturers")
class ManufacturerController(private val manufacturerService: ManufacturerService) {


    @Operation(summary = "Get all manufacturers")
    @GetMapping
    fun findAll(@RequestParam(defaultValue = "{}") params: Map<String, String>): List<ManufacturerResponseDTO> {
        return manufacturerService.findAllByComplexQuery(params)
    }

    @Operation(summary = "Get manufacturer by id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): Manufacturer {
        return manufacturerService.findById(id)
    }

    @Operation(summary = "Create a new manufacturer")
    @PostMapping
    fun save(@RequestBody manufacturer: Manufacturer): Manufacturer {
        return manufacturerService.save(manufacturer)
    }

    @Operation(summary = "Update manufacturer")
    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody manufacturer: ManufacturerUpdateDTO): Manufacturer {
        return manufacturerService.update(id, manufacturer)
    }

    @Operation(summary = "Update manufacturer")
    @PatchMapping("/{id}")
    fun patch(@PathVariable id: UUID, @RequestBody manufacturer: ManufacturerUpdateDTO): Manufacturer {
        return manufacturerService.updatePatch(id, manufacturer)
    }

    @Operation(summary = "Delete manufacturer")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return manufacturerService.deleteById(id)
    }

}
