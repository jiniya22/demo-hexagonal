package me.jiniworld.demohx.application.notice.service

import kotlinx.coroutines.flow.map
import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.application.notice.domain.Notice
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

    override fun getNoticeSummaries(command: GetNoticesCommand) =
        loadNoticePort.loadNotices(PageRequest.of(command.page, command.size, Sort.by(
            Sort.Order.desc("id")))).map { it.summary }

    override suspend fun getNoticeDetail(id: String): Notice.Detail? =
        loadNoticePort.loadNotice(id)?.detail()
}