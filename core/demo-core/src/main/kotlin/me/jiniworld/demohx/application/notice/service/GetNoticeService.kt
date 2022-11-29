package me.jiniworld.demohx.application.notice.service

import me.jiniworld.demohx.application.notice.port.input.GetNoticeQuery
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.port.output.NoticeDetail
import me.jiniworld.demohx.application.notice.port.output.NoticeSimple
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional(readOnly = true)
@Component
internal class GetNoticeService(
    private val loadNoticePort: LoadNoticePort,
) : GetNoticeQuery {

    override fun getNoticeSimple(pageable: Pageable) =
        loadNoticePort.loadNotices(pageable)?.map { it.mapToNoticeSimple() }

    override fun getNoticeDetail(id: Long): NoticeDetail? =
        loadNoticePort.loadNotice(id)?.mapToNoticeDetail()
}