package me.jiniworld.demohx.notice.application.port.input

data class RegisterNoticeCommand(
    val title: String,
    val content: String,
)
