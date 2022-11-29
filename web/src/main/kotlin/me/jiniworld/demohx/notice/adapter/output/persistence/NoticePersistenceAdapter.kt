package me.jiniworld.demohx.notice.adapter.output.persistence

import me.jiniworld.demohx.notice.application.port.output.LoadNoticePort
import me.jiniworld.demohx.notice.domain.Notice
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

internal class NoticePersistenceAdapter(
    private val noticeRepository: NoticeRepository,
) : LoadNoticePort {
    override fun loadNotices(pageable: Pageable): List<Notice> {

        println(">>>>>>>>> 3")
        return noticeRepository.findAllBy(pageable).map { it.mapToNotice() }.toList()
    }

    override fun loadNotice(id: Long): Notice? {
        return Notice(id = id, title = "zzz", content = "fff", createdAt = LocalDateTime.now())
//        return noticeRepository.findById(id)?.map(NoticeEntity::mapToNotice)
    }
}