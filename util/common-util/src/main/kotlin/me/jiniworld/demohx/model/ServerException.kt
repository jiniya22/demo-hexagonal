package me.jiniworld.demohx.model

sealed class ServerException(
    val code: Int,
    override val message: String
): RuntimeException(message)

data class NotFoundException(
    override val message: String,
): ServerException(404, message)

data class UnauthorizedException(
    override val message: String = "access_token 이 유효하지 않습니다.",
): ServerException(401, message)
