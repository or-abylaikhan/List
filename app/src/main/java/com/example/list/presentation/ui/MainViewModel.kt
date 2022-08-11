package com.example.list.presentation.ui

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.domain.model.ShopItem
import com.example.list.domain.use_case.AddShopItemUseCase
import com.example.list.domain.use_case.DeleteShopItemUseCase
import com.example.list.domain.use_case.EditShopItemUseCase
import com.example.list.domain.use_case.GetShopListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getShopListUseCase: GetShopListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val addShopItemUseCase: AddShopItemUseCase
) : ViewModel() {

    fun getShopList() =
        Transformations.map(getShopListUseCase.getShopList()) { list -> list.sortedByDescending { it.isActive } }

    fun addShopItem(item: ShopItem) = viewModelScope.launch { addShopItemUseCase.addShopItem(item) }

    fun editShopItem(item: ShopItem) =
        viewModelScope.launch { editShopItemUseCase.editShopItem(item) }

    fun changedEnabledState(item: ShopItem) =
        viewModelScope.launch { editShopItemUseCase.editShopItem(item.copy(isActive = !item.isActive)) }

    fun deleteShopItem(item: ShopItem) =
        viewModelScope.launch { deleteShopItemUseCase.deleteShopItem(item) }
}