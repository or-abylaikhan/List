package com.example.list.data.repository

import androidx.lifecycle.Transformations
import com.example.list.data.database.ShopItemDao
import com.example.list.data.mapper.ShopItemMapper
import com.example.list.domain.model.ShopItem
import com.example.list.domain.repository.ShopItemRepository

class ShopItemRepositoryImpl(private val dao: ShopItemDao, private val mapper: ShopItemMapper) :
    ShopItemRepository {

    override fun getShopList() = Transformations.map(dao.getAll()) { mapper.from(it) }

    override suspend fun getShopItem(id: Int): ShopItem = mapper.from(dao.getShopItem(id))

    override suspend fun addShopItem(item: ShopItem) = dao.insertShopItem(mapper.to(item))

    override suspend fun editShopItem(item: ShopItem) = dao.updateShopItem(mapper.to(item))

    override suspend fun deleteShopItem(item: ShopItem) = dao.deleteShopItem(mapper.to(item))
}