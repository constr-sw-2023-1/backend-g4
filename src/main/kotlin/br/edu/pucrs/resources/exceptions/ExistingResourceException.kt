package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class ExistingResourceException(
    override val message: String = "Conflict with existing resource",
    override val code: String = "G4-003",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val errors: List<String> = listOf("[Resources API] Conflict with existing resource")
) : RuntimeException(message), RestException
