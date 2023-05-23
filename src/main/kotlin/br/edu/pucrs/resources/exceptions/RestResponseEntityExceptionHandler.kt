package br.edu.pucrs.resources.exceptions

import br.edu.pucrs.resources.dto.response.ErrorResponseDTO
import br.edu.pucrs.resources.dto.response.error.Error
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
    fun handleRestException(ex: RestException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(ex)
    }

    @Override
    fun handleValidationException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponseDTO>
    {
        val errors = exception.bindingResult.allErrors

        val requestValidationException = RequestValidationException("Validation error: ${errors.first().defaultMessage!!}")

        return buildResponseEntity(requestValidationException)
    }

    private fun buildResponseEntity(exception: RestException): ResponseEntity<ErrorResponseDTO> {
        val response = ErrorResponseDTO(errors = Stack<Error>())


        response.errors.push(Error(source = exception.source, code = exception.code, message = exception.message, stack = exception.stack))

        if (response.errors.count { error -> error.source == "Resources API" } == 0) {
            response.errors.add(0,Error(
                source = "Resources API",
                code = "G4-007",
                message = "An error occurred calling an external service.",
                stack = exception.stack))
        }


        return ResponseEntity.status(exception.status).body(response)
    }

    @ExceptionHandler(org.springframework.security.core.AuthenticationException::class)
    fun handleAuthenticationException(authException: org.springframework.security.core.AuthenticationException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthenticationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(InvalidBearerTokenException::class)
    fun handleInvalidBearerTokenException(authException: InvalidBearerTokenException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthenticationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(authException: AccessDeniedException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(AuthorizationException(message = authException.message!!, stack = authException.stackTrace
            .filter { s -> s.toString().contains("br.edu.pucrs") }
            .map { s -> s.toString() }))
    }

    @ExceptionHandler(MongoClientException::class)
    fun handleMongoTimeoutException(mongoException: MongoClientException): ResponseEntity<ErrorResponseDTO> {
        return buildResponseEntity(MongoException(message = mongoException.message!!,
            stack = mongoException.stackTrace
                .filter { s -> s.toString().contains("br.edu.pucrs") }
                .map { s -> s.toString() }))
    }

}
