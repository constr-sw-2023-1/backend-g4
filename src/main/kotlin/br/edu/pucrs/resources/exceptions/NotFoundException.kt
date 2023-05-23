package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class NotFoundException(
    override val source: String = "Resources API",
    override val message: String = "Resource not found",
    override val status: HttpStatus = HttpStatus.NOT_FOUND,
    override val code: String = "G4-005",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException
