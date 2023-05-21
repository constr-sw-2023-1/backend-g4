package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class ExistingResourceException(
    override val message: String = "Conflict with existing resource",
    override val code: String = "G4-009",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST
) : RuntimeException(message), RestException
