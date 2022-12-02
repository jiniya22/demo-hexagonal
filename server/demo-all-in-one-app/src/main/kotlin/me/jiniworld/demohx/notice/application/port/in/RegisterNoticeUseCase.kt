package me.jiniworld.demohx.notice.application.port.`in`

interface RegisterNoticeUseCase {
    fun registerNotice(command: RegisterNoticeCommand)
}