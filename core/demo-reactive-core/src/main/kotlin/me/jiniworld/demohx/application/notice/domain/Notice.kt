package me.jiniworld.demohx.application.notice.domain

import me.jiniworld.demohx.DateTimeUtils
import java.time.LocalDateTime

data class Notice(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
) {
    fun mapToNoticeSimple() =
        NoticeSimple(id = id, title = title, createdOn = DateTimeUtils.toDateString(createdAt))

    fun mapToNoticeDetail() =
        NoticeDetail(id = id, title = title, content = content, createdAt = DateTimeUtils.toString(createdAt))
}