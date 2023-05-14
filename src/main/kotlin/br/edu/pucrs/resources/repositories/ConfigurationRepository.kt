package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.domain.Configuration
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ConfigurationRepository : MongoRepository<Configuration, UUID> {
}