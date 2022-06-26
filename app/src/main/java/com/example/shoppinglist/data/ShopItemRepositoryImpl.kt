package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository

class ShopItemRepositoryImpl(private val dao: ShopItemDao, private val mapper: ShopItemMapper) :
    ShopItemRepository {

    override fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(dao.getAll()) { mapper.from(it) }

    override fun getShopItem(id: Int): ShopItem = mapper.from(dao.getShopItem(id))

    override fun addShopItem(item: ShopItem) = dao.insertShopItem(mapper.to(item))

    override fun editShopItem(item: ShopItem) = dao.updateShopItem(mapper.to(item))

    override fun deleteShopItem(item: ShopItem) = dao.deleteShopItem(mapper.to(item))
}