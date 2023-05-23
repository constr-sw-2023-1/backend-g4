package br.edu.pucrs.resources.dto.response.error

data class ErrorDTO (
    val source: String,
    val code: String?,
    val description: String,
    val cause: Cause
)