package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopItem(id: Int) = shopItemRepository.getShopItem(id)
}