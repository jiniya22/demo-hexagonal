package me.jiniworld.demohx.notice.adapter.output.persistence

import me.jiniworld.demohx.notice.domain.Notice
import me.jiniworld.demohx.notice.domain.NoticeInfo
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

    constructor() {}

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun mapToNotice() =
        Notice(id = id, noticeInfo = NoticeInfo(title = title, content = content), createdAt = createdAt)
}
