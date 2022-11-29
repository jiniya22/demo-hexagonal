package me.jiniworld.demohx.persistence.notice

import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort {
    override fun loadNotices(pageable: Pageable): List<Notice>? {
        return noticeRepository.findAllBy(pageable).map { it.mapToNotice() }.toList()
    }

    override fun loadNotice(id: Long): Notice? {
        return noticeRepository.findByIdOrNull(id)?.mapToNotice()
    }
}