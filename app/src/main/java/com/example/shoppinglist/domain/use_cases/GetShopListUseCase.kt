package com.example.shoppinglist.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> = shopItemRepository.getShopList()
}