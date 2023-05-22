package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class MongoException(
    override val message: String = "An error has occurred with MongoDB",
    override val code: String = "G4-004",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
) : RuntimeException(message), RestException{
    override val errors: Queue<String> = LinkedList(listOf("[MongoDB] $message"))
}