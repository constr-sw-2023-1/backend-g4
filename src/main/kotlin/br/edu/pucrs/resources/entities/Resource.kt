package br.edu.pucrs.resources.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "resources")
class Resource(
    @Id
    var id: UUID,
    var descricao: String? = null,
    var fabricante: String? = null,
    var tipo: Type? = null,
)