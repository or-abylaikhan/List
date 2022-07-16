package com.example.list.domain.use_case

import com.example.list.domain.model.ShopItem
import com.example.list.domain.repository.ShopItemRepository

class EditShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun editShopItem(item: ShopItem) = shopItemRepository.editShopItem(item)
}