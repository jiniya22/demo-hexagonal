package me.jiniworld.demohx.application.port.output

import me.jiniworld.demohx.domain.Notice
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): List<Notice>
    fun loadNotice(id: Long): Notice?
}