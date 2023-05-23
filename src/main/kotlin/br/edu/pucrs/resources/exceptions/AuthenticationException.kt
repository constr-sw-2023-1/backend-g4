package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class AuthenticationException(
    override val source: String = "Keycloak",
    override val message: String = "Could not validate the provided credentials",
    override val status: HttpStatus = HttpStatus.UNAUTHORIZED,
    override val code: String = "G4-001",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException