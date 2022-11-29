package me.jiniworld.demohx.notice.application.port.input

import me.jiniworld.demohx.notice.domain.Notice
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
interface GetNoticeQuery {
    fun getNoticeSimple(pageable: Pageable): List<Notice>
    fun getNoticeDetail(noticeId: Long): Notice?
}