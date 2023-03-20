package me.jiniworld.demohx.application.notice.port.input

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple

interface GetNoticeQuery {
    fun getNoticeSimples(command: GetNoticesCommand): Flow<NoticeSimple>
    suspend fun getNoticeDetail(id: String): NoticeDetail?
}