package me.jiniworld.demohx.persistence.notice

import me.jiniworld.demohx.DateTimeUtils
import me.jiniworld.demohx.application.notice.domain.Notice

internal object NoticeMapper {

    fun mapToNotice(doc: NoticeDocument) =
        Notice(summary = Notice.Summary(id = doc.id, title = doc.title,
            createdAt = DateTimeUtils.toString(doc.createdAt)), content = doc.content)

    fun mapToDocument(notice: Notice) =
        NoticeDocument(title = notice.summary.title, content = notice.content)

}