package me.jiniworld.demohx.notice.application.port.out

data class NoticeDetail(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: String,
)