package me.jiniworld.demohx.application.notice.port.input

import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple

interface GetNoticeQuery {
    suspend fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    suspend fun getNoticeDetail(id: String): NoticeDetail?
}