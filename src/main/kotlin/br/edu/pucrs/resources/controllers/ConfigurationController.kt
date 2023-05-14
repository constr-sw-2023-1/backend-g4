package br.edu.pucrs.resources.controllers

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.services.ConfigurationService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/configuration")
class ConfigurationController(private val configurationService: ConfigurationService) {
    @PostMapping
    fun save(@RequestBody configuration: Configuration): Configuration {
        return configurationService.save(configuration)
    }

    @GetMapping
    fun findAll(): List<Configuration> {
        return configurationService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): Configuration {
        return configurationService.findById(id)
    }
}