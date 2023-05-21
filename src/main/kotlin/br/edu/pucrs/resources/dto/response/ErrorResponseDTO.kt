package br.edu.pucrs.resources.dto.response

data class ErrorResponseDTO(
    val code: String,
    val message: String,
    val errors: List<String>
)