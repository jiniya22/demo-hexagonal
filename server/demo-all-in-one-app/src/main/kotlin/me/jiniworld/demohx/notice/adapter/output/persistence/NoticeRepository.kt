package me.jiniworld.demohx.notice.adapter.output.persistence

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
internal interface NoticeRepository: JpaRepository<NoticeEntity, Long> {
    fun findAllBy(pageable: Pageable): List<NoticeEntity>
}