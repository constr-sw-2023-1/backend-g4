package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.domain.Type
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeRepository : MongoRepository<Type, UUID> {

    fun findByName(name: String): List<Type>

    fun findByNameLike(name: String): List<Type>

}
