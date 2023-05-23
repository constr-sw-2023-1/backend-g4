package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class RequestValidationException(
    override val source: String = "Resources API",
    override val message: String = "Request has failed on validation",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val code: String = "G4-006",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException