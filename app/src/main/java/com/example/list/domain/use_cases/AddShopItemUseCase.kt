package com.example.list.domain.use_cases

import com.example.list.domain.ShopItem
import com.example.list.domain.ShopItemRepository

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun addShopItem(item: ShopItem) = shopItemRepository.addShopItem(item)
}