package br.edu.pucrs.resources.domain


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("types")
class Type{
        @Id
        var _id: UUID? = UUID.randomUUID()
        var name: String? = null
}
