package me.jiniworld.demohx.persistence.item

import me.jiniworld.demohx.application.item.domain.Item

internal object ItemMapper {

    fun mapToDomainEntity(doc: ItemDocument): Item {
        return Item(doc.id, doc.name, doc.price, doc.stock)
    }

}