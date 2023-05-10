package br.edu.pucrs.resources.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Type(
        @Id @GeneratedValue
        var id: UUID? = null,
        var nome: String? = null
)
