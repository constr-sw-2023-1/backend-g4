package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class NotFoundException(
    override val message: String = "Resource not found",
    override val code: String = "G4-005",
    override val status: HttpStatus = HttpStatus.NOT_FOUND,
) : RuntimeException(message), RestException {
    override val errors: Queue<String> = LinkedList(listOf("[Resources API] $message"))
}
