package br.edu.pucrs.resources.services

import br.edu.pucrs.resources.domain.Configuration
import br.edu.pucrs.resources.repositories.ConfigurationRepository
import org.springframework.stereotype.Service

@Service
class ConfigurationService(private val configurationRepository: ConfigurationRepository) {

    fun save(configuration: Configuration): Configuration {
        return configurationRepository.save(configuration)
    }

    fun findAll(): List<Configuration> {
        return configurationRepository.findAll()
    }

    fun updatePatch(newConfiguration: Configuration): Configuration {
        return configurationRepository.save(newConfiguration)
    }

}