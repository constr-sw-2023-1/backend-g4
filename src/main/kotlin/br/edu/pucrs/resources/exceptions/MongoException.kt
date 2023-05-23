package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class MongoException(
    override val source: String = "MongoDB",
    override val message: String = "An error has occurred with MongoDB",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val code: String = "G4-004",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException