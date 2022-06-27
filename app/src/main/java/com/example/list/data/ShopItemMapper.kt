package com.example.list.data

import com.example.list.domain.Mapper
import com.example.list.domain.ShopItem

class ShopItemMapper : Mapper<ShopItemDbModel, ShopItem> {
    override fun from(model: ShopItemDbModel): ShopItem =
        ShopItem(model.id, model.name, model.count, model.description, model.isActive)

    override fun to(model: ShopItem): ShopItemDbModel =
        ShopItemDbModel(model.id, model.name, model.count, model.description, model.isActive)

    override fun from(model: List<ShopItemDbModel>): List<ShopItem> = model.map { from(it) }

    override fun to(model: List<ShopItem>): List<ShopItemDbModel> = model.map { to(it) }
}