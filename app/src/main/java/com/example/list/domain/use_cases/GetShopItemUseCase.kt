package com.example.list.domain.use_cases

import com.example.list.domain.ShopItemRepository

class GetShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun getShopItem(id: Int) = shopItemRepository.getShopItem(id)
}