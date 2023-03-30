package me.jiniworld.demohx.application.notice.port.input

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.notice.domain.Notice

interface GetNoticeQuery {
    fun getNoticeSummaries(command: GetNoticesCommand): Flow<Notice.Summary>
    suspend fun getNoticeDetail(id: String): Notice.Detail?
}