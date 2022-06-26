package com.example.shoppinglist.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopItemRepository

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> = shopItemRepository.getShopList()
}