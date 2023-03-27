package me.jiniworld.demohx.persistence.item

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.jiniworld.demohx.annotation.PersistenceAdapter
import me.jiniworld.demohx.application.item.domain.Item
import me.jiniworld.demohx.application.item.port.output.LoadItemPort
import org.springframework.data.domain.Pageable

@PersistenceAdapter
internal class ItemPersistenceAdapter(
    private val itemRepository: ItemRepository,
): LoadItemPort {

    override suspend fun loadItem(id: String): Item? {
        return itemRepository.findById(id)
            ?.let { ItemMapper.mapToDomainEntity(it) }
    }

    override fun loadItems(pageable: Pageable): Flow<Item> {
        return itemRepository.findAllBy(pageable)
            .map { ItemMapper.mapToDomainEntity(it) }
    }

    override fun loadItems(ids: Collection<String>): Flow<Item> {
        return itemRepository.findAllById(ids)
            .map { ItemMapper.mapToDomainEntity(it) }
    }

}