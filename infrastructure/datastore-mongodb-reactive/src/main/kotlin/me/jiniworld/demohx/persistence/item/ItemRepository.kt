package me.jiniworld.demohx.persistence.item

import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
internal interface ItemRepository: CoroutineCrudRepository<ItemDocument, String> {
    fun findAllBy(pageable: Pageable): Flow<ItemDocument>
}