package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class AuthorizationException(
    override val message: String = "User is not authorized to access this resource",
    override val code: String = "G4-003",
    override val status: HttpStatus = HttpStatus.FORBIDDEN,
) : RuntimeException(message), RestException
