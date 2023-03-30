package me.jiniworld.demohx.config.exception

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConversionException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ValidationException

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException) : ResponseEntity<ErrorResponse> {
        logger.error { ex.message }

        return ResponseEntity.status(ex.code).body(ErrorResponse(code = ex.code, message = ex.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorResponse> {
        logger.error { ex.message }

        var message: String?
        var code: Int

        when(ex) {
            is MethodArgumentTypeMismatchException -> {
                message = String.format("지원하지 않는 %s 입니다. 입력 가능한 값: %s",
                    ex.name, ex.requiredType?.enumConstants?.joinToString { it.toString() })
                code = 400
            }
            is ValidationException, is HttpMessageConversionException, is IllegalArgumentException, is ArrayIndexOutOfBoundsException -> {
                message = ex.message
                code = 400
            }
            else -> {
                message = "Internal Server Error";
                code = 500
            }
        }

        return ResponseEntity.status(code).body(ErrorResponse(code = code, message = message ?: ""))
    }
}