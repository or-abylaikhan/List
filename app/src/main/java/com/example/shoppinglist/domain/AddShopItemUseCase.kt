package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun addShopItem(item: ShopItem) = shopItemRepository.addShopItem(item)
}