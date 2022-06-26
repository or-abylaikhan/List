package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopItemRepository

class EditShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun editShopItem(item: ShopItem) = shopItemRepository.editShopItem(item)
}