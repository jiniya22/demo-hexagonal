package me.jiniworld.demohx.application.notice.port.input

import me.jiniworld.demohx.application.notice.port.output.NoticeDetail
import me.jiniworld.demohx.application.notice.port.output.NoticeSimple

interface GetNoticeQuery {
    fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    fun getNoticeDetail(id: Long): NoticeDetail?
}