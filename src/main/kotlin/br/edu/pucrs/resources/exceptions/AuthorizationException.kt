package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class AuthorizationException(
    override val source: String = "Keycloak",
    override val message: String = "User is not authorized to access this resource",
    override val status: HttpStatus = HttpStatus.FORBIDDEN,
    override val code: String = "G4-002",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException