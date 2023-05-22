package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.LinkedList
import java.util.Queue

class RequestValidationException(
    override val message: String = "Request has failed on validation",
    override val code: String = "G4-006",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,

) : RuntimeException(message), RestException {
    override val errors: Queue<String> = LinkedList(listOf("[Resources API] $message"))
}