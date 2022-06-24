package com.example.shoppinglist.domain

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList() = shopItemRepository.getShopList()
}