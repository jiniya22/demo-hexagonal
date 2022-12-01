package me.jiniworld.demohx.notice.application.port.out

import me.jiniworld.demohx.notice.domain.Notice
import org.springframework.data.domain.Pageable

interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): List<Notice>?
    fun loadNotice(id: Long): Notice?
}