package br.edu.pucrs.resources.dto.response.error

data class Error (
    val source: String,
    val code: String?,
    val message: String,
    val stack: List<String>? = null
)