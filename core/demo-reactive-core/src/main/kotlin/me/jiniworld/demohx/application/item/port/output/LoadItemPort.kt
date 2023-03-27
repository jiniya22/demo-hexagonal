package me.jiniworld.demohx.application.item.port.output

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.item.domain.Item
import org.springframework.data.domain.Pageable

interface LoadItemPort {
    suspend fun loadItem(id: String): Item?
    fun loadItems(pageable: Pageable): Flow<Item>
    fun loadItems(ids: Collection<String>): Flow<Item>
}