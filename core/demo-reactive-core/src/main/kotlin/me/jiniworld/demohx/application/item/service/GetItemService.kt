package me.jiniworld.demohx.application.item.service

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.application.item.domain.Item
import me.jiniworld.demohx.application.item.port.input.GetItemQuery
import me.jiniworld.demohx.application.item.port.input.GetItemsCommand
import me.jiniworld.demohx.application.item.port.output.LoadItemPort
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
internal class GetItemService(
    private val loadItemPort: LoadItemPort,
): GetItemQuery {

    override fun getItems(command: GetItemsCommand): Flow<Item> {
        return loadItemPort.loadItems(
            PageRequest.of(command.page, command.size, Sort.by(
                Sort.Order.desc("id")))
        )
    }
}