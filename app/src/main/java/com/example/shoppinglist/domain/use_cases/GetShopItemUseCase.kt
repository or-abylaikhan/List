package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.domain.ShopItemRepository

class GetShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
   suspend fun getShopItem(id: Int) = shopItemRepository.getShopItem(id)
}