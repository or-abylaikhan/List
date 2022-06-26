package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository

class EditShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    suspend fun editShopItem(item: ShopItem) = shopItemRepository.editShopItem(item)
}