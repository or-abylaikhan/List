package com.example.shoppinglist.domain

interface ShopItemRepository {

    fun getShopList(): List<ShopItem>

    fun getShopItem(id: Int): ShopItem

    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun deleteShopItem(id: Int)
}