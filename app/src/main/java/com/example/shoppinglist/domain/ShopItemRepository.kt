package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

interface ShopItemRepository {

    fun getShopList(): List<ShopItem>

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun deleteShopItem(item: ShopItem)
}