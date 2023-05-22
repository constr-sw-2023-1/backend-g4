package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class ExistingResourceException(
    override val message: String = "Conflict with existing resource",
    override val code: String = "G4-003",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
) : RuntimeException(message), RestException {
    override val errors: Queue<String> = LinkedList(listOf("[Resources API] $message"))
}
