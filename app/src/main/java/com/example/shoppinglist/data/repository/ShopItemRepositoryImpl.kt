package com.example.shoppinglist.data.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglist.data.database.ShopItemDao
import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopItemRepository

class ShopItemRepositoryImpl(private val dao: ShopItemDao) : ShopItemRepository {
    override fun getShopList(): LiveData<List<ShopItem>> = dao.getAll()

    override fun getShopItem(id: Int): ShopItem = dao.getShopItem(id)

    override fun addShopItem(item: ShopItem) = dao.insertShopItem(item)

    override fun editShopItem(item: ShopItem) = dao.updateShopItem(item)

    override fun deleteShopItem(item: ShopItem) = dao.deleteShopItem(item)
}