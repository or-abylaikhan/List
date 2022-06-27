package com.example.list.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.list.domain.ShopItem
import com.example.list.domain.ShopItemRepository

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> = shopItemRepository.getShopList()
}