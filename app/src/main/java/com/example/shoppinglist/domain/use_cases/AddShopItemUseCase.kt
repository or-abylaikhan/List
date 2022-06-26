package com.example.shoppinglist.domain.use_cases

import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopItemRepository

class AddShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun addShopItem(item: ShopItem) = shopItemRepository.addShopItem(item)
}