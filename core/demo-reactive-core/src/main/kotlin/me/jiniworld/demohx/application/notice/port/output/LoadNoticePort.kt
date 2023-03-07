package me.jiniworld.demohx.application.notice.port.output

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple
import org.springframework.data.domain.Pageable

interface LoadNoticePort {
    fun loadNotices(pageable: Pageable): Flow<NoticeSimple>
    suspend fun loadNotice(id: String): NoticeDetail?
}