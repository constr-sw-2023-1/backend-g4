package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.*

class ExistingResourceException(
    override val source: String = "Resources API",
    override val message: String = "Conflict with existing resource",
    override val status: HttpStatus = HttpStatus.BAD_REQUEST,
    override val code: String = "G4-003",
    override val stack: List<String> = Thread.currentThread().stackTrace.map { it.toString() }.filter { s -> s.contains("br.edu.pucrs") }
) : RuntimeException(message), RestException
