package br.edu.pucrs.resources.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Component (
        @Id @GeneratedValue
        val id: UUID = UUID.randomUUID(),
        var component: String,
        var description: String,
)