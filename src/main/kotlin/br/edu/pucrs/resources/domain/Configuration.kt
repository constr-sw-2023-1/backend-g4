package br.edu.pucrs.resources.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("configurations")
class Configuration {
        @Id
        var id: UUID? = UUID.randomUUID()
        var component: String? = null
        var description: String? = null
}
