package br.edu.pucrs.group4.backendg4.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
data class Resource(
        @Id @GeneratedValue
        var id: UUID? = null,
        var tipo: String,
        var descricao: String,
        var fabricante: String
)
