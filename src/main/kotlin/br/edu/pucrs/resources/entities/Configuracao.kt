package br.edu.pucrs.resources.entities

import jakarta.persistence.*
import java.util.*

@Entity
class Configuracao (
        @Id @GeneratedValue
        var id: UUID,
        @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "id")
        var resource: Resource
)