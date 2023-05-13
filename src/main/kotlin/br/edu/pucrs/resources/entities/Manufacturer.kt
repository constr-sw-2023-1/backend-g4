package br.edu.pucrs.resources.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
class Manufacturer (
        @Id @GeneratedValue
        val id: UUID = UUID.randomUUID(),
        var name: String,
)