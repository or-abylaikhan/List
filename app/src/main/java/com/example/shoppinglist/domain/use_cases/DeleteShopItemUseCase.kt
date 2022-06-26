package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopItemRepository

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun deleteShopItem(item: ShopItem) = shopItemRepository.deleteShopItem(item)
}