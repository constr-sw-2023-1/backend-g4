package br.edu.pucrs.resources.entities

import jakarta.persistence.*
import java.util.*

@Entity
class Resource(
    @Id @GeneratedValue
        var id: UUID,
    var descricao: String? = null,
    var fabricante: String? = null,
    @ManyToOne
        var tipo: Type? = null,

    )