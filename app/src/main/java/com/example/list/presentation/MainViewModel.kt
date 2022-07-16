package com.example.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.domain.ShopItem
import com.example.list.domain.use_cases.AddShopItemUseCase
import com.example.list.domain.use_cases.DeleteShopItemUseCase
import com.example.list.domain.use_cases.EditShopItemUseCase
import com.example.list.domain.use_cases.GetShopListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getShopListUseCase: GetShopListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val addShopItemUseCase: AddShopItemUseCase
) : ViewModel() {

    fun getShopList(): LiveData<List<ShopItem>> = getShopListUseCase.getShopList()

    fun addShopItem(item: ShopItem) {
        viewModelScope.launch { addShopItemUseCase.addShopItem(item) }
    }

    fun editShopItem(item: ShopItem) {
        viewModelScope.launch { editShopItemUseCase.editShopItem(item) }
    }

    fun changedEnabledState(item: ShopItem) {
        viewModelScope.launch { editShopItemUseCase.editShopItem(item.copy(isActive = !item.isActive)) }
    }

    fun deleteShopItem(item: ShopItem) {
        viewModelScope.launch { deleteShopItemUseCase.deleteShopItem(item) }
    }
}