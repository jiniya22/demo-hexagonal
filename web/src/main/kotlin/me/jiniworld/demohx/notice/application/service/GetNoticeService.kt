package me.jiniworld.demohx.notice.application.service

import me.jiniworld.demohx.notice.application.port.input.GetNoticeQuery
import me.jiniworld.demohx.notice.application.port.output.LoadNoticePort
import me.jiniworld.demohx.notice.domain.Notice
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.sql.DriverManager.println

@Transactional(readOnly = true)
@Component
internal class GetNoticeService(
    private val loadNoticePort: LoadNoticePort,
) : GetNoticeQuery {

    override fun getNoticeSimple(pageable: Pageable): List<Notice> {
        println(">>>>>>>>> 2")
        return loadNoticePort.loadNotices(pageable)
//        return loadNoticePort.loadNotices(pageable).map { it.mapToNoticeSimple() }.toList()
    }

    override fun getNoticeDetail(id: Long): Notice? {
        return loadNoticePort.loadNotice(id)
//        return loadNoticePort.loadNotice(id)?.mapToNoticeDetail()
    }
}