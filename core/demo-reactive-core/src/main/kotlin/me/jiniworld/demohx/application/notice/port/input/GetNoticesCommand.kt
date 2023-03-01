package me.jiniworld.demohx.application.notice.port.input

data class GetNoticesCommand(
    val page: Int,
    val size: Int,
)
