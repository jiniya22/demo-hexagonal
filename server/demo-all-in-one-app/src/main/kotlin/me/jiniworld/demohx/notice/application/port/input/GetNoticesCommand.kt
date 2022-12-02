package me.jiniworld.demohx.notice.application.port.input

data class GetNoticesCommand(
    val page: Int,
    val size: Int,
)
