package me.jiniworld.demohx.application.notice.port.output

data class NoticeDetail(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
)