package br.edu.pucrs.resources.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Component (
        @Id
        @GeneratedValue
        var id: UUID,
        var nome: String? = null,
        var descricao: String? = null,
)