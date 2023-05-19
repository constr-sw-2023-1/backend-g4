package br.edu.pucrs.resources.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("resources")
class Resource{
        @Id
        var id: UUID? = UUID.randomUUID()
        var description: String? = null
        var type: Type? = null
        var manufacturer: Manufacturer? = null
        var configurations: ArrayList<Configuration> = arrayListOf()
}