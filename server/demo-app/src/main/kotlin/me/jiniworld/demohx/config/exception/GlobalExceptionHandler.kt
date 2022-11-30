package me.jiniworld.demohx.config.exception

import me.jiniworld.demohx.model.BaseResponse
import me.jiniworld.demohx.model.ServerException
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
internal class GlobalExceptionHandler: ResponseEntityExceptionHandler() {
    private val logging = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException): ResponseEntity<BaseResponse> {
        logging.error { ex.message }
        return ResponseEntity.status(ex.code)
            .body(BaseResponse(result = "fail", reason = ex.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<BaseResponse> {
        logging.error { ex.message }
        return ResponseEntity.internalServerError()
            .body(BaseResponse(result = "fail", reason = "Internal Server Error"))
    }
}