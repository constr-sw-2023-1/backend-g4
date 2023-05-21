package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class AuthenticationException(
    override val message: String = "Could not validate the provided credentials",
    override val code: String = "G4-001",
    override val status: HttpStatus = HttpStatus.UNAUTHORIZED,
    override val errors: List<String> = listOf("[Keycloak] Could not validate the provided credentials")
) : RuntimeException(message), RestException