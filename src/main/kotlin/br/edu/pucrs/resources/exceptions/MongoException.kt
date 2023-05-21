package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

class MongoException(
    override val message: String = "An error has occurred with MongoDB",
    override val code: String = "G4-004",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val errors: List<String> = listOf("An error has occurred with MongoDB")
) : RuntimeException(message), RestException