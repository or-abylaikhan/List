package com.example.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglist.data.model.ShopItem

interface ShopItemRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun deleteShopItem(item: ShopItem)
}