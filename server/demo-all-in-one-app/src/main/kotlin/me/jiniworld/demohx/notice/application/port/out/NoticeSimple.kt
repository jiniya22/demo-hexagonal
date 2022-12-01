package me.jiniworld.demohx.notice.application.port.out

data class NoticeSimple(
    val id: Long,
    val title: String,
    val createdOn: String,
)