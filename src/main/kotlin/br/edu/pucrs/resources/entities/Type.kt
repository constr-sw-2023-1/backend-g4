package br.edu.pucrs.resources.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "types")
class Type(
        val id: UUID = UUID.randomUUID(),
        var name: String
)
