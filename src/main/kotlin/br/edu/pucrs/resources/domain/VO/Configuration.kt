package br.edu.pucrs.resources.domain.VO

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("configurations")
class Configuration {
        var component: String? = null
        var description: String? = null
}
