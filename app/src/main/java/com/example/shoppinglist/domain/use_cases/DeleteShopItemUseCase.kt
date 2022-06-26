package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
   suspend fun deleteShopItem(item: ShopItem) = shopItemRepository.deleteShopItem(item)
}