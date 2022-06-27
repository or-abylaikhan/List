package com.example.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.domain.ShopItem
import com.example.list.domain.use_cases.DeleteShopItemUseCase
import com.example.list.domain.use_cases.EditShopItemUseCase
import com.example.list.domain.use_cases.GetShopListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getShopListUseCase: GetShopListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
) : ViewModel() {

    fun getShopList(): LiveData<List<ShopItem>> = getShopListUseCase.getShopList()

    fun changedEnabledState(item: ShopItem) {
        viewModelScope.launch {
            editShopItemUseCase.editShopItem(item.copy(isEnabled = !item.isEnabled))
        }
    }

    fun deleteShopItem(item: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(item)
        }
    }
}