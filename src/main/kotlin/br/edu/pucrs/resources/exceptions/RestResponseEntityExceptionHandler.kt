package br.edu.pucrs.resources.exceptions

import br.edu.pucrs.resources.dto.response.ErrorResponseDTO
import com.mongodb.MongoClientException
import com.mongodb.MongoTimeoutException
import org.springframework.http.ResponseEntity

import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(
        value = [
            RequestValidationException::class,
            NotFoundException::class,
            AuthenticationException::class,
            AuthorizationException::class,
            ExistingResourceException::class,
        ]
    )
    fun handleRestException(ex: RestException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(ex)
    }

    @Override
    fun handleValidationException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponseDTO>
    {
        val errors = exception.bindingResult.allErrors

        val requestValidationException = RequestValidationException(message = "Validation error: ${errors.first().defaultMessage!!}", errors = listOf("Validation error: ${errors.first().defaultMessage!!}"))

        return buildResponseEntity(requestValidationException)
    }

    private fun buildResponseEntity(exception: RestException): ResponseEntity<ErrorResponseDTO> {
        val response = ErrorResponseDTO(
            exception.code,
            exception.message,
            exception.errors
        )

        return ResponseEntity.status(exception.status).body(response)
    }

    @ExceptionHandler(org.springframework.security.core.AuthenticationException::class)
    fun handleAuthenticationException(authException: org.springframework.security.core.AuthenticationException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthenticationException())
    }

    @ExceptionHandler(InvalidBearerTokenException::class)
    fun handleInvalidBearerTokenException(authException: InvalidBearerTokenException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthenticationException())
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(authException: AccessDeniedException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthorizationException())
    }

    @ExceptionHandler(MongoClientException::class)
    fun handleMongoTimeoutException(mongoException: MongoClientException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(MongoException(mongoException.message!!, errors = listOf("[MongoDB] ${mongoException.message}")))
    }

}
