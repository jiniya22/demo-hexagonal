package me.jiniworld.demohx.notice.application.port.input

import me.jiniworld.demohx.notice.application.port.output.NoticeDetail
import me.jiniworld.demohx.notice.application.port.output.NoticeSimple

interface GetNoticeQuery {
    fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    fun getNoticeDetail(id: Long): NoticeDetail?
}