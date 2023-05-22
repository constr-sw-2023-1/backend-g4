package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class AuthenticationException(
    override val message: String = "Could not validate the provided credentials",
    override val code: String = "G4-001",
    override val status: HttpStatus = HttpStatus.UNAUTHORIZED,
) : RuntimeException(message), RestException {
    override val errors: Queue<String> = LinkedList(listOf("[Keycloak] $message"))
}