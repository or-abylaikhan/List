package com.example.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.use_cases.DeleteShopItemUseCase
import com.example.shoppinglist.domain.use_cases.EditShopItemUseCase
import com.example.shoppinglist.domain.use_cases.GetShopListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getShopListUseCase: GetShopListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
) : ViewModel() {

    fun getShopList(): LiveData<List<ShopItem>> = getShopListUseCase.getShopList()

    fun changedEnabledState(item: ShopItem) {
        viewModelScope.launch {
            editShopItemUseCase.editShopItem(item.apply { isEnabled = !isEnabled })
        }
    }

    fun deleteShopItem(item: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(item)
        }
    }
}