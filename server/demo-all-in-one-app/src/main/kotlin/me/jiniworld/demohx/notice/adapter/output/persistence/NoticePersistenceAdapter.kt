package me.jiniworld.demohx.notice.adapter.output.persistence

import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.notice.application.port.output.LoadNoticePort
import me.jiniworld.demohx.notice.application.port.output.SaveNoticePort
import me.jiniworld.demohx.notice.domain.Notice
import me.jiniworld.demohx.notice.domain.NoticeContent
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort, SaveNoticePort {
    override fun loadNotices(pageable: Pageable): List<Notice>? {
        return noticeRepository.findAllBy(pageable).map { it.mapToNotice() }.toList()
    }

    override fun loadNotice(id: Long): Notice? {
        return noticeRepository.findByIdOrNull(id)?.mapToNotice()
    }

    override fun saveNotice(noticeContent: NoticeContent) {
        TODO("Not yet implemented")
    }
}