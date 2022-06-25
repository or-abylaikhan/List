package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItemRepository

class ShopItemRepositoryImpl(private val dao: ShopItemDao) : ShopItemRepository {
    override fun getShopList(): List<ShopItem> = dao.getAll()

    override fun getShopItem(id: Int): ShopItem = dao.getShopItem(id)

    override fun addShopItem(item: ShopItem) = dao.insertShopItem(item)

    override fun editShopItem(item: ShopItem) = dao.updateShopItem(item)

    override fun deleteShopItem(item: ShopItem) = dao.deleteShopItem(item)
}