package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class EditShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun editShopItem(item: ShopItem) = shopItemRepository.editShopItem(item)
}