package me.jiniworld.demohx.persistence.notice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import org.springframework.data.domain.Pageable

@PersistenceAdapter
internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort {
    override fun loadNotices(pageable: Pageable): Flow<NoticeSimple> {
        return noticeRepository.findAllBy(pageable).map { it.mapToNoticeSimple() }
    }

    override suspend fun loadNotice(id: String): NoticeDetail? {
        return noticeRepository.findById(id)?.mapToNoticeDetail()
    }
}