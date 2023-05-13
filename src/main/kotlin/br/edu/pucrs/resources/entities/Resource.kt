package br.edu.pucrs.resources.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "resources")
class Resource(
    @Id
    val id: UUID = UUID.randomUUID(),
    var description: String,
    var type: Type,
    var manufacturer: Manufacturer,
    var configuration: List<Component> = emptyList()
)