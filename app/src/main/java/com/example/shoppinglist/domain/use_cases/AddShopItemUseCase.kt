package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun addShopItem(item: ShopItem) = shopItemRepository.addShopItem(item)
}