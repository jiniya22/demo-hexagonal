package me.jiniworld.demohx.notice.application.port.output

data class NoticeSimple(
    val id: Long,
    val title: String,
    val createdOn: String,
)