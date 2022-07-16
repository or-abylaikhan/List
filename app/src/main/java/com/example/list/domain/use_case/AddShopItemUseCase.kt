package com.example.list.domain.use_case

import com.example.list.domain.model.ShopItem
import com.example.list.domain.repository.ShopItemRepository

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun addShopItem(item: ShopItem) = shopItemRepository.addShopItem(item)
}