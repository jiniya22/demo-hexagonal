package me.jiniworld.demohx.persistence.notice.repository

import me.jiniworld.demohx.persistence.notice.entity.NoticeEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

internal interface NoticeRepository: JpaRepository<NoticeEntity, Long> {
    fun findAllBy(pageable: Pageable): List<NoticeEntity>
}