package com.example.shoppinglist.domain

class DeleteShopItemUseCase(private val shopItemRepository: ShopItemRepository) {
    fun deleteShopItem(id: Int) = shopItemRepository.deleteShopItem(id)
}