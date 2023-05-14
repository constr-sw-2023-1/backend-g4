package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.entities.Type
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeRepository : MongoRepository<Type, UUID>
