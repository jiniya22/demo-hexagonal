package me.jiniworld.demohx.notice.application.port.output

data class NoticeDetail(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
)