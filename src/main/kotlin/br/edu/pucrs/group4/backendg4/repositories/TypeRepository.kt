package br.edu.pucrs.group4.backendg4.repositories

import br.edu.pucrs.group4.backendg4.entities.Type
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeRepository : JpaRepository<Type, UUID>
