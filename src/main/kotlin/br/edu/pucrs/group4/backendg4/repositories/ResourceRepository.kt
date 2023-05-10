package br.edu.pucrs.group4.backendg4.repositories

import br.edu.pucrs.group4.backendg4.entities.Resource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ResourceRepository : JpaRepository<Resource, UUID>
