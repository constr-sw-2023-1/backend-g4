package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.VO.Configuration
import br.edu.pucrs.resources.dto.request.ConfigurationRequestDTO
import br.edu.pucrs.resources.dto.response.ConfigurationResponseDTO
import br.edu.pucrs.resources.services.ConfigurationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Configurations API", description = "Endpoints for Configurations API")
@RestController
@RequestMapping("/resources/configurations")
    class ConfigurationController(private val configurationService: ConfigurationService) {

    @Operation(summary = "Get configurations by resource id")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<List<Configuration>> {
        val configuration = configurationService.findById(id)
        return ResponseEntity.ok(configuration)
    }

    @Operation(summary = "Create configurations by resource id")
    @PostMapping("/{id}")
    fun save(@PathVariable id:UUID, @RequestBody configuration: List<ConfigurationRequestDTO>): ResponseEntity<List<ConfigurationResponseDTO>> {
        val createdConfiguration =  configurationService.save(id,configuration)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConfiguration)
    }

    @Operation(summary = "Update configurations by resource id")
    @PutMapping("/{id}")
    fun update(@PathVariable id:UUID, @RequestBody configuration: List<ConfigurationRequestDTO>): ResponseEntity<List<ConfigurationResponseDTO>> {
        val updatedConfiguration = configurationService.update(id, configuration)
        return ResponseEntity.ok(updatedConfiguration)
    }

    @Operation(summary = "Delete configurations by resource id")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        return configurationService.deleteById(id)
    }

}
