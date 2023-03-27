package me.jiniworld.demohx.application.item.port.input

import kotlinx.coroutines.flow.Flow
import me.jiniworld.demohx.application.item.domain.Item


interface GetItemQuery {
    fun getItems(command: GetItemsCommand): Flow<Item>
}