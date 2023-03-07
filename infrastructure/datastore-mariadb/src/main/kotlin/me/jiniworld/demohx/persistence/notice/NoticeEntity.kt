package me.jiniworld.demohx.persistence.notice

import me.jiniworld.demohx.DateTimeUtils
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.domain.NoticeDetail
import me.jiniworld.demohx.application.notice.domain.NoticeSimple
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Table(name = "notice")
@Entity
internal class NoticeEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var title: String = ""

    var content: String = ""

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    fun mapToNotice() =
        Notice(id = id, title = title, content = content, createdAt = createdAt)

    fun mapToNoticeSimple() =
        NoticeSimple(id = id, title = title, createdOn = DateTimeUtils.toDateString(createdAt))

    fun mapToNoticeDetail() =
        NoticeDetail(id = id, title = title, content = content, createdAt = DateTimeUtils.toString(createdAt))
    
}
