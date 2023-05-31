package br.edu.pucrs.resources.domain


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("types")
class Type{
        @Id
        var id: UUID? = UUID.randomUUID()
        var name: String? = null
        var active: Boolean = true
}
