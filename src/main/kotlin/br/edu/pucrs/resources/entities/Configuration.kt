package br.edu.pucrs.resources.entities

import jakarta.persistence.*
import java.util.*

@Entity
class Configuration (
        @Id @GeneratedValue
        val id: UUID = UUID.randomUUID(),
        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "id")
        var resource: Resource
)