package me.jiniworld.demohx.application.port.input

import me.jiniworld.demohx.domain.Notice
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
interface GetNoticeQuery {
    fun getNoticeSimple(pageable: Pageable): List<Notice>
    fun getNoticeDetail(noticeId: Long): Notice?
}