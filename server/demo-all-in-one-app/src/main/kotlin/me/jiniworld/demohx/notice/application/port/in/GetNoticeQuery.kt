package me.jiniworld.demohx.notice.application.port.`in`

import me.jiniworld.demohx.notice.application.port.out.NoticeDetail
import me.jiniworld.demohx.notice.application.port.out.NoticeSimple

interface GetNoticeQuery {
    fun getNoticeSimples(command: GetNoticesCommand): List<NoticeSimple>?
    fun getNoticeDetail(id: Long): NoticeDetail?
}