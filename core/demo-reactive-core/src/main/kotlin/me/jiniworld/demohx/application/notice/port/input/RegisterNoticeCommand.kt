package me.jiniworld.demohx.application.notice.port.input

data class RegisterNoticeCommand(
    val title: String,
    val content: String,
)