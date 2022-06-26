package com.example.shoppinglist.data

import com.example.shoppinglist.domain.Mapper
import com.example.shoppinglist.domain.ShopItem

class ShopItemMapper : Mapper<ShopItemDbModel, ShopItem> {
    override fun from(model: ShopItemDbModel): ShopItem =
        ShopItem(model.name, model.count, model.isEnabled, model.id)

    override fun to(model: ShopItem): ShopItemDbModel =
        ShopItemDbModel(model.id, model.name, model.count, model.isEnabled)

    override fun from(model: List<ShopItemDbModel>): List<ShopItem> = model.map { from(it) }

    override fun to(model: List<ShopItem>): List<ShopItemDbModel> = model.map { to(it) }
}