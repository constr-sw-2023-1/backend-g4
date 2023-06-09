package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.domain.Resource
import br.edu.pucrs.resources.domain.Type
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.BasicQuery
import org.springframework.stereotype.Repository


@Repository
class TypeRepositoryImpl (private val mongoTemplate: MongoTemplate) {

    fun findAllByComplexQuery(params: Map<String, String>): List<Type> {
        val query = BasicQuery(buildFilter(params))
        return mongoTemplate.find(query, Type::class.java)
    }

    private fun buildFilter(params: Map<String, String>) : String {
        val sb = StringBuilder("{ ")

        params.forEach { (key, value) ->
            run {
                sb.append(buildKey(key))
                sb.append("{ ")

                val split = value.replace("%",".*").split("}")

                sb.append(getOperator(if(split.count() == 1) "eq" else split[0]))
                sb.append(":")
                sb.append("'")
                sb.append(if(split.count() == 1) split[0] else split[1])
                sb.append("'")
                sb.append("}")
                sb.append(",")
            }
        }
        sb.append(" }")

        return sb.toString()
    }

    private fun getOperator(value: String): String {
        return when (value.replace("{", "")) {
            "eq" -> "\$eq"
            "neq" -> "\$neq"
            "gt" -> "\$gt"
            "gteq" -> "\$gte"
            "lt" -> "\$lt"
            "lteq" -> "\$lte"
            "like" -> "\$regex"
            else -> {""}
        }
    }

    private fun buildKey(key: String): String {
        return "'$key': "
    }
}

