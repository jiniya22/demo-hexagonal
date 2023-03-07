package me.jiniworld.demohx.application.notice.port.output

import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple
import org.springframework.data.domain.Pageable

interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): List<NoticeSimple>?
    fun loadNotice(id: Long): NoticeDetail?
}