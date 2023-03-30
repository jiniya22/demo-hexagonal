package me.jiniworld.demohx.persistence.notice

import me.jiniworld.demohx.DateTimeUtils
import me.jiniworld.demohx.application.notice.domain.Notice

internal object NoticeMapper {

    fun mapToNotice(entity: NoticeEntity) =
        Notice(summary = Notice.Summary(id = entity.id, title = entity.title,
            createdAt = DateTimeUtils.toString(entity.createdAt)), content = entity.content)

}