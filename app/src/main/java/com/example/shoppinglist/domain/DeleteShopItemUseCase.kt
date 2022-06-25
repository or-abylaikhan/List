package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun deleteShopItem(item: ShopItem) = shopItemRepository.deleteShopItem(item)
}