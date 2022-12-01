package me.jiniworld.demohx.notice.domain

import me.jiniworld.demohx.DateTimeUtils
import me.jiniworld.demohx.notice.application.port.out.NoticeDetail
import me.jiniworld.demohx.notice.application.port.out.NoticeSimple
import java.time.LocalDateTime

data class Notice(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
) {
    fun mapToNoticeSimple() =
        NoticeSimple(id = id, title = title, createdOn = DateTimeUtils.toDateString(createdAt))

    fun mapToNoticeDetail() =
        NoticeDetail(id = id, title = title, content = content, createdAt = DateTimeUtils.toString(createdAt))
}