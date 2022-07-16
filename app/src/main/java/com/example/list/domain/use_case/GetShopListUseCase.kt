package com.example.list.domain.use_case

import androidx.lifecycle.LiveData
import com.example.list.domain.model.ShopItem
import com.example.list.domain.repository.ShopItemRepository

class GetShopListUseCase(private val shopItemRepository: ShopItemRepository) {
    fun getShopList(): LiveData<List<ShopItem>> = shopItemRepository.getShopList()
}