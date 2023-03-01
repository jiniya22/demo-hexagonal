package me.jiniworld.demohx.application.notice.port.input

import me.jiniworld.demohx.application.notice.port.output.NoticeDetail
import me.jiniworld.demohx.application.notice.port.output.NoticeSimple

interface GetNoticeQuery {
    suspend fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    suspend fun getNoticeDetail(id: String): NoticeDetail?
}