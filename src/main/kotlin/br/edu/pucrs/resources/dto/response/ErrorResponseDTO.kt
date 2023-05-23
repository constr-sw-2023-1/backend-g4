package br.edu.pucrs.resources.dto.response

import br.edu.pucrs.resources.dto.response.error.Error
import java.util.Stack

data class ErrorResponseDTO(
    val errors: Stack<Error>
)