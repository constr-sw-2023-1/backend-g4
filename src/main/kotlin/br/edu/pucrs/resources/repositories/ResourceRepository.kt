package br.edu.pucrs.resources.repositories

<<<<<<< HEAD
import br.edu.pucrs.resources.domain.Resource
import org.springframework.data.mongodb.repository.MongoRepository
=======
import org.springframework.data.mongodb.repository.MongoRepository
import br.edu.pucrs.resources.domain.Resource
>>>>>>> 68c771612413638cd237879cfa499dda6513ef40
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ResourceRepository : MongoRepository<Resource, UUID>
