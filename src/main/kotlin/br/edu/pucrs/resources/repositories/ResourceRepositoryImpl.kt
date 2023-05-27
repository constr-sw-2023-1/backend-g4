package br.edu.pucrs.resources.repositories

import br.edu.pucrs.resources.domain.Resource
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.BasicQuery
import org.springframework.stereotype.Repository


@Repository
class ResourceRepositoryImpl (private val mongoTemplate: MongoTemplate) {

    fun findAllByComplexQuery(params: Map<String, String>): List<Resource> {
        val query = BasicQuery(buildFilter(params, true))
        val result: List<Resource> = mongoTemplate.find(query, Resource::class.java)
        return result
    }

    fun findAllBySimpleQuery(params: Map<String, String>): List<Resource> {
        val query = BasicQuery(buildFilter(params, false))
        val result: List<Resource> = mongoTemplate.find(query, Resource::class.java)
        return result
    }

    private fun buildFilter(params: Map<String, String>, isComplexQuery: Boolean) : String {

        val sb = StringBuilder("{ ")

        params.forEach { (key, value) ->
            run {
                var operator = "eq"
                var param = value

                if (isComplexQuery) {
                    val splited = value.split("}")
                    operator = getOperator(splited[0])
                    param = splited[1]
                }
//                sb.append(buildKey(key))
//                sb.append("{ ")

//                sb.append(getOperator(splited[0]))
//                sb.append(":")
//                sb.append("'")
//                sb.append(splited[1])
//                sb.append("'")
//                sb.append("}")
//                sb.append(",")

                val bk = buildKey(key)

                sb.append("$bk { $operator: '$param' }, ")
            }
        }
        sb.append(" }")

        return sb.toString()
    }

    private fun getOperator(value: String): String {
        val operator: String = value.replace("{", "")
        return when (operator) {
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

