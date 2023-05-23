package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.domain.Manufacturer
import br.edu.pucrs.resources.domain.Resource
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.javapoet.TypeName
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ResourceRepository : MongoRepository<Resource, UUID> {
    fun findByDescriptionLike(description: String): List<Resource>
    fun findAllByType_Name(typeName: String): List<Resource>
    fun findAllByManufacturer_Name(manufacturerName: String): List<Resource>
}
