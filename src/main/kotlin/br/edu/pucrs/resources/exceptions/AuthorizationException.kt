package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class AuthorizationException(
    override val message: String = "User is not authorized to access this resource",
    override val code: String = "G4-002",
    override val status: HttpStatus = HttpStatus.FORBIDDEN,
) : RuntimeException(message), RestException{
    override val errors: Queue<String> = LinkedList(listOf("[Keycloak] $message"))
}
