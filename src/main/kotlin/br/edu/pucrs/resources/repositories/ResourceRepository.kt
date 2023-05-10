package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.entities.Resource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ResourceRepository : JpaRepository<Resource, UUID>
