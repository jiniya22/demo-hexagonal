package me.jiniworld.demohx.adapter.output.persistence

import me.jiniworld.demohx.domain.Notice
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
}
