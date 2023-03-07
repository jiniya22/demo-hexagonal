package me.jiniworld.demohx.persistence.notice

import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort {
    override fun loadNotices(pageable: Pageable): List<NoticeSimple>? {
        return noticeRepository.findAllBy(pageable).map { it.mapToNoticeSimple() }.toList()
    }

    override fun loadNotice(id: Long): NoticeDetail? {
        return noticeRepository.findByIdOrNull(id)?.mapToNoticeDetail()
    }
}