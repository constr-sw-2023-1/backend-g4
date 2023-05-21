package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class NotFoundException(
    override val message: String = "Resource not found",
    override val code: String = "G4-004",
    override val status: HttpStatus = HttpStatus.NOT_FOUND,
) : RuntimeException(message), RestException
