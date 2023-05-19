package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.services.ConfigurationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Configurations API", description = "endpoints configuration api")
@RestController
@RequestMapping("/configurations")
class ConfigurationController(private val configurationService: ConfigurationService) {

    @Operation(summary = "Create a new configuration")
    @PostMapping
    fun save(@RequestBody configuration: Configuration): Configuration {
        return configurationService.save(configuration)
    }

    @Operation(summary = "Get all configurations")
    @GetMapping
    fun findAll(): List<Configuration> {
        return configurationService.findAll()
    }

    @Operation(summary = "Update configurations")
    @PatchMapping
    fun updatePatch(@RequestBody configuration: Configuration): ResponseEntity<Configuration> {
        val configuration = configurationService.updatePatch(configuration)
        return ResponseEntity.ok(configuration)
    }

}