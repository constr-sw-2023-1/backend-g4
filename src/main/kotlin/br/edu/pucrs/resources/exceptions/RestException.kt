package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

interface RestException {
    val message: String
    val code: String
    val status: HttpStatus
    val errors: List<String>
}