package br.edu.pucrs.resources.exceptions

import br.edu.pucrs.resources.dto.response.ErrorResponse
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
            BadRequestException::class,
            NotFoundException::class,
            AuthenticationException::class,
            AuthorizationException::class,
            ExistingResourceException::class,
        ]
    )
    fun handleRestException(ex: RestException): ResponseEntity<ErrorResponse> {
        return buildResponseEntity(ex)
    }

    @Override
    fun handleValidationException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse>
    {
        val errors = exception.bindingResult.allErrors

        val badRequestException = BadRequestException("Validation error: ${errors.first().defaultMessage!!}")

        return buildResponseEntity(badRequestException)
    }

    private fun buildResponseEntity(exception: RestException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            exception.code,
            exception.message
        )
        return ResponseEntity.status(exception.status).body(response)
    }

    @ExceptionHandler(org.springframework.security.core.AuthenticationException::class)
    fun handleAuthenticationException(authException: org.springframework.security.core.AuthenticationException): ResponseEntity<ErrorResponse> {
        return buildResponseEntity(AuthenticationException())
    }

    @ExceptionHandler(InvalidBearerTokenException::class)
    fun handleInvalidBearerTokenException(authException: InvalidBearerTokenException): ResponseEntity<ErrorResponse> {
        return buildResponseEntity(AuthenticationException())
    }

    @ExceptionHandler(org.springframework.security.access.AccessDeniedException::class)
    fun handleAccessDeniedException(authException: AccessDeniedException): ResponseEntity<ErrorResponse> {
        return buildResponseEntity(AuthorizationException())
    }
}
