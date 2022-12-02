package me.jiniworld.demohx.notice.domain

import me.jiniworld.demohx.DateTimeUtils
import me.jiniworld.demohx.notice.application.port.output.NoticeDetail
import me.jiniworld.demohx.notice.application.port.output.NoticeSimple
import java.time.LocalDateTime

data class Notice(
    val id: Long,
    val noticeInfo: NoticeInfo,
    val createdAt: LocalDateTime,
) {
    fun mapToNoticeSimple() =
        NoticeSimple(id = id, title = noticeInfo.title, createdOn = DateTimeUtils.toDateString(createdAt))

    fun mapToNoticeDetail() =
        NoticeDetail(id = id, title = noticeInfo.title, content = noticeInfo.content, createdAt = DateTimeUtils.toString(createdAt))
}