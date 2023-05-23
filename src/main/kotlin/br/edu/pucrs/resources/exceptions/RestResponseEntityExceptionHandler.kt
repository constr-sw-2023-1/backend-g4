package br.edu.pucrs.resources.exceptions

import br.edu.pucrs.resources.dto.response.error.Cause
import br.edu.pucrs.resources.dto.response.error.ErrorDTO
import com.mongodb.MongoClientException
import org.springframework.http.ResponseEntity

import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


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
    fun handleRestException(ex: RestException): ResponseEntity<List<ErrorDTO>> {
        return buildResponseEntity(ex)
    }

    @Override
    fun handleValidationException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<List<ErrorDTO>>
    {
        val errors = exception.bindingResult.allErrors

        val requestValidationException = RequestValidationException("Validation error: ${errors.first().defaultMessage!!}")

        return buildResponseEntity(requestValidationException)
    }

    private fun buildResponseEntity(exception: RestException): ResponseEntity<List<ErrorDTO>> {
        val response = mutableListOf<ErrorDTO>()

        response.add(ErrorDTO(
            source = exception.source,
            code = exception.code,
            description = "An error occurred while processing your request.",
            cause = Cause(
                message = exception.message,
                stack = exception.stack
            )
        ))

        if (response.count { error -> error.source == "Resources API" } == 0) {
            response.clear()
            response.add(0,ErrorDTO(
                source = "Resources API",
                code = exception.code,
                description = "An error has occurred while calling ${exception.source}.",
                cause = Cause(
                    message = exception.message,
                    stack = exception.stack
                )
            ))
        }


        return ResponseEntity.status(exception.status).body(response)
    }

    @ExceptionHandler(org.springframework.security.core.AuthenticationException::class)
    fun handleAuthenticationException(authException: org.springframework.security.core.AuthenticationException): ResponseEntity<List<ErrorDTO>> {
        return buildResponseEntity(AuthenticationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(InvalidBearerTokenException::class)
    fun handleInvalidBearerTokenException(authException: InvalidBearerTokenException): ResponseEntity<List<ErrorDTO>> {
        return buildResponseEntity(AuthenticationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(authException: AccessDeniedException): ResponseEntity<List<ErrorDTO>> {
        return buildResponseEntity(AuthorizationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(MongoClientException::class)
    fun handleMongoTimeoutException(mongoException: MongoClientException): ResponseEntity<List<ErrorDTO>> {
        return buildResponseEntity(MongoException(message = mongoException.message!!,
            stack = mongoException.stackTrace
                .filter { s -> s.toString().contains("br.edu.pucrs") }
                .map { s -> s.toString() }))
    }

}
