package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.entities.Type
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeRepository : JpaRepository<Type, UUID>
