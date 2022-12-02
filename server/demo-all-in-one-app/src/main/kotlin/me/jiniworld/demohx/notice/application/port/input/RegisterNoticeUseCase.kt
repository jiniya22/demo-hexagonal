package me.jiniworld.demohx.notice.application.port.input

interface RegisterNoticeUseCase {
    fun registerNotice(command: RegisterNoticeCommand)
}