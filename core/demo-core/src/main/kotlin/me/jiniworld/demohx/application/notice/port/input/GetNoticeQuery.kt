package me.jiniworld.demohx.application.notice.port.input

import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple

interface GetNoticeQuery {
    fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    fun getNoticeDetail(id: Long): NoticeDetail?
}