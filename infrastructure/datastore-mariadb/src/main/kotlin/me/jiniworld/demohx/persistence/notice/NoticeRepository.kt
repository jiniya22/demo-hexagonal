package me.jiniworld.demohx.persistence.notice

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
internal interface NoticeRepository: JpaRepository<NoticeEntity, Long> {
    fun findAllBy(pageable: Pageable): List<NoticeEntity>
}