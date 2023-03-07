package me.jiniworld.demohx.application.notice.service

import kotlinx.coroutines.flow.toList
import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.port.input.GetNoticeQuery
import me.jiniworld.demohx.application.notice.port.input.GetNoticesCommand
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
internal class GetNoticeService(
    private val loadNoticePort: LoadNoticePort,
) : GetNoticeQuery {

    override suspend fun getNoticeSimples(command: GetNoticesCommand) =
        loadNoticePort.loadNotices(PageRequest.of(command.page, command.size, Sort.by(
            Sort.Order.desc("id"))))
            .toList()

    override suspend fun getNoticeDetail(id: String): NoticeDetail? =
        loadNoticePort.loadNotice(id)
}