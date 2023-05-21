package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class AuthenticationException(
    override val message: String = "Invalid or missing credentials",
    override val code: String = "G4-001",
    override val status: HttpStatus = HttpStatus.UNAUTHORIZED)
    : RuntimeException(message), RestException