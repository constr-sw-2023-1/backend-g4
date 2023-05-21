package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class BadRequestException(
    override val message: String = "Invalid input",
    override val code: String = "G4-002",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST
) : RuntimeException(message), RestException