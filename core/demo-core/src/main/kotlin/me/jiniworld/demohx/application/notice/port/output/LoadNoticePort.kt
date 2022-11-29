package me.jiniworld.demohx.application.notice.port.output

import me.jiniworld.demohx.application.notice.domain.Notice
import org.springframework.data.domain.Pageable

interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): List<Notice>?
    fun loadNotice(id: Long): Notice?
}