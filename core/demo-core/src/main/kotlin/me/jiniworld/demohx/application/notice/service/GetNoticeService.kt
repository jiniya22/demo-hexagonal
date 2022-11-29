package me.jiniworld.demohx.application.notice.service

import me.jiniworld.demohx.application.notice.port.input.GetNoticeQuery
import me.jiniworld.demohx.application.notice.port.input.GetNoticesCommand
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import me.jiniworld.demohx.application.notice.port.output.NoticeDetail
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Component
internal class GetNoticeService(
    private val loadNoticePort: LoadNoticePort,
) : GetNoticeQuery {

    override fun getNoticeSimple(command: GetNoticesCommand) =
        loadNoticePort.loadNotices(PageRequest.of(command.page, command.size, Sort.by(Sort.Order.desc("id"))))
            ?.map { it.mapToNoticeSimple() }

    override fun getNoticeDetail(id: Long): NoticeDetail? =
        loadNoticePort.loadNotice(id)?.mapToNoticeDetail()
}