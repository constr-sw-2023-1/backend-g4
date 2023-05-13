package br.edu.pucrs.resources.entities

import jakarta.persistence.*
import java.util.*

@Entity
class Resource(
        @Id @GeneratedValue
        val id: UUID = UUID.randomUUID(),

        var description: String,

        @ManyToOne
        var type: Type,

        @ManyToOne
        var manufacturer: Manufacturer,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "configuration")
        @JoinColumn(name = "resource_id")
        var configuration: List<Component> = emptyList()
)