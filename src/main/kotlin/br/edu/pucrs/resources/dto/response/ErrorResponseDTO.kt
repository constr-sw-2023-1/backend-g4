package br.edu.pucrs.resources.dto.response

import java.util.Queue

data class ErrorResponseDTO(
    val code: String,
    val message: String,
    val errors: Queue<String>
)