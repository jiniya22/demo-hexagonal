package me.jiniworld.demohx.application.item.port.input

data class GetItemsCommand(
    val page: Int,
    val size: Int,
)
