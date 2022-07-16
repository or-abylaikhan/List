package com.example.list.domain.repository

import androidx.lifecycle.LiveData
import com.example.list.domain.model.ShopItem

interface ShopItemRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    suspend fun getShopItem(id: Int): ShopItem

    suspend fun addShopItem(item: ShopItem)

    suspend fun editShopItem(item: ShopItem)

    suspend fun deleteShopItem(item: ShopItem)
}