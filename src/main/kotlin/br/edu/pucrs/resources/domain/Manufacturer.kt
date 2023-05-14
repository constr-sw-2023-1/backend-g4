package br.edu.pucrs.resources.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("manufacturers")
class Manufacturer {
        @Id
        var _id: UUID? = UUID.randomUUID()
        var name: String? = null
}