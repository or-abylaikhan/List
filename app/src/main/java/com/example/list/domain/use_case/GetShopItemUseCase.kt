package com.example.list.domain.use_case

import com.example.list.domain.repository.ShopItemRepository

class GetShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun getShopItem(id: Int) = shopItemRepository.getShopItem(id)
}