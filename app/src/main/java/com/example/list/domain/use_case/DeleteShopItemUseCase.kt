package com.example.list.domain.use_case

import com.example.list.domain.model.ShopItem
import com.example.list.domain.repository.ShopItemRepository

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun deleteShopItem(item: ShopItem) = shopItemRepository.deleteShopItem(item)
}