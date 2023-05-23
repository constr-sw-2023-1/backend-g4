package br.edu.pucrs.resources.dto.response.error

data class Cause (
    val message: String,
    val stack: List<String>? = emptyList()
)