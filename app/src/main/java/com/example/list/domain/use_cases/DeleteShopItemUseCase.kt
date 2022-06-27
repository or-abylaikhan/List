package com.example.list.domain.use_cases

import com.example.list.domain.ShopItem
import com.example.list.domain.ShopItemRepository

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun deleteShopItem(item: ShopItem) = shopItemRepository.deleteShopItem(item)
}