package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class RequestValidationException(
    override val message: String = "Request has failed on validation",
    override val code: String = "G4-006",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val errors: List<String> = listOf("[Resources API] Request has failed on validation")
) : RuntimeException(message), RestException