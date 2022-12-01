package me.jiniworld.demohx.notice.application.service

import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.notice.application.port.`in`.GetNoticeQuery
import me.jiniworld.demohx.notice.application.port.`in`.GetNoticesCommand
import me.jiniworld.demohx.notice.application.port.out.LoadNoticePort
import me.jiniworld.demohx.notice.application.port.out.NoticeDetail
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
internal class GetNoticeService(
    private val loadNoticePort: LoadNoticePort,
) : GetNoticeQuery {

    override fun getNoticeSimples(command: GetNoticesCommand) =
        loadNoticePort.loadNotices(PageRequest.of(command.page, command.size, Sort.by(Sort.Order.desc("id"))))
            ?.map { it.mapToNoticeSimple() }

    override fun getNoticeDetail(id: Long): NoticeDetail? =
        loadNoticePort.loadNotice(id)?.mapToNoticeDetail()
}