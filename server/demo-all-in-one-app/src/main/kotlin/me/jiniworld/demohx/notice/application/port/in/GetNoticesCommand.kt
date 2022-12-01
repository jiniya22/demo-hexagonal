package me.jiniworld.demohx.notice.application.port.`in`

data class GetNoticesCommand(
    val page: Int,
    val size: Int,
)
