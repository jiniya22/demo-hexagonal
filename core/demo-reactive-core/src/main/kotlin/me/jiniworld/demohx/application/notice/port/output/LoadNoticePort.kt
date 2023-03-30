package me.jiniworld.demohx.application.notice.port.output

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.notice.domain.Notice
import org.springframework.data.domain.Pageable

interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): Flow<Notice>
    suspend fun loadNotice(id: String): Notice?
}