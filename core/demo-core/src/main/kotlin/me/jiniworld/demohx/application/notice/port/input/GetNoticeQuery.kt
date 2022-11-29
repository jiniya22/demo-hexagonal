package me.jiniworld.demohx.application.notice.port.input

import me.jiniworld.demohx.application.notice.port.output.NoticeDetail
import me.jiniworld.demohx.application.notice.port.output.NoticeSimple
import org.springframework.data.domain.Pageable

interface GetNoticeQuery {
    fun getNoticeSimple(pageable: Pageable): List<NoticeSimple>?
    fun getNoticeDetail(noticeId: Long): NoticeDetail?
}