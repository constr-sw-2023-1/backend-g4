package br.edu.pucrs.resources.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import br.edu.pucrs.resources.domain.Resource
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ResourceRepository : MongoRepository<Resource, UUID>
