package br.edu.pucrs.resources.exceptions

import org.springframework.http.HttpStatus

interface RestException {
    val source: String
    val message: String
    val status: HttpStatus
    val code: String
    val stack: List<String>?
}