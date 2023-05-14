package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.exceptions.ResourceNotFoundException
import br.edu.pucrs.resources.repositories.ConfigurationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConfigurationService(private val configurationRepository: ConfigurationRepository) {

    fun save(configuration: Configuration): Configuration {
        return configurationRepository.save(configuration)
    }

    fun findAll(): List<Configuration> {
        return configurationRepository.findAll()
    }

    fun findById(id: UUID): Configuration {
        return configurationRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Configuration not found")
        }
    }

    fun findAllByConfigurationsUUID(configurationsUUID: ArrayList<UUID>): ArrayList<Configuration> {
        return configurationsUUID.map{
            findById(it)
        } as ArrayList<Configuration>
    }

}