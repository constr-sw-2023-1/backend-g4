package br.edu.pucrs.resources.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("resources")
class Resource{
        @Id
        var _id: UUID? = UUID.randomUUID()
        var description: String? = null
        var type: Type? = null
        var manufacturer: Manufacturer? = null
        var configuration: ArrayList<Configuration> = arrayListOf()
}