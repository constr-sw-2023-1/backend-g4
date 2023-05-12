package br.edu.pucrs.resources.entities

import jakarta.persistence.*
import java.util.*

@Entity
class Resource(
        @Id @GeneratedValue
        var id: UUID,

        var descricao: String? = null,

        @ManyToOne
        var fabricante: Fabricante? = null,

        @ManyToOne
        var tipo: Type? = null,

        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "configuracao")
        @JoinColumn(name = "resource_id")
        var components: List<Component> = emptyList()
)