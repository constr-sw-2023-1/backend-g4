package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus
import java.util.Queue

interface RestException {
    val message: String
    val code: String
    val status: HttpStatus
    val errors: Queue<String>
}