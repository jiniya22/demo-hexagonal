package me.jiniworld.demohx.application.notice.port.input

interface RegisterNoticeUseCase {
    suspend fun registerNotice(command: RegisterNoticeCommand)
}