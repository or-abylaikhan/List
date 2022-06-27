package com.example.list.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    suspend fun getShopItem(id: Int): ShopItem

    suspend fun addShopItem(item: ShopItem)

    suspend fun editShopItem(item: ShopItem)

    suspend fun deleteShopItem(item: ShopItem)
}