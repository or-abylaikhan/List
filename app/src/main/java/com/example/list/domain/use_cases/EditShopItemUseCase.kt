package com.example.list.domain.use_cases

import com.example.list.domain.ShopItem
import com.example.list.domain.ShopItemRepository

class EditShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun editShopItem(item: ShopItem) = shopItemRepository.editShopItem(item)
}