package me.jiniworld.demohx.adapter.output.persistence

import me.jiniworld.demohx.application.port.output.LoadNoticePort
import me.jiniworld.demohx.domain.Notice
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
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