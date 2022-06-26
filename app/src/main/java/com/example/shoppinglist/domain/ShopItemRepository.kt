package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun deleteShopItem(item: ShopItem)
}