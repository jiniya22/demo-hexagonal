package me.jiniworld.demohx.application.notice.domain

import java.time.LocalDateTime

data class Notice(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
)