package me.jiniworld.demohx.persistence.notice

import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface NoticeRepository: CoroutineCrudRepository<NoticeEntity, String> {
    fun findAllBy(pageable: Pageable): Flow<NoticeEntity>
}