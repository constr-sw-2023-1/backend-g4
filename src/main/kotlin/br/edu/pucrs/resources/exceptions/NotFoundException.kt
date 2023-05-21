package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class NotFoundException(
    override val message: String = "Resource not found",
    override val code: String = "G4-005",
    override val status: HttpStatus = HttpStatus.NOT_FOUND,
    override val errors: List<String> = listOf("[Resources API] Resource not found")
) : RuntimeException(message), RestException
