package me.jiniworld.demohx.persistence.notice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.port.output.LoadNoticePort
import me.jiniworld.demohx.application.notice.port.output.SaveNoticePort
import org.springframework.data.domain.Pageable

@PersistenceAdapter
internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort, SaveNoticePort {
    override fun loadNotices(pageable: Pageable): Flow<Notice> {
        return noticeRepository.findAllBy(pageable).map { NoticeMapper.mapToNotice(it) }
    }

    override suspend fun loadNotice(id: String): Notice? {
        return noticeRepository.findById(id)?.let { NoticeMapper.mapToNotice(it) }
    }

    override suspend fun saveNotice(notice: Notice) {
        noticeRepository.save(NoticeMapper.mapToDocument(notice))
    }
}