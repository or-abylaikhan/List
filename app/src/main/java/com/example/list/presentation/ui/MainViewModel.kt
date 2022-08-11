package com.example.list.presentation.ui

import androidx.lifecycle.LiveData
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
    private val editUseCase: EditShopItemUseCase,
    private val deleteUseCase: DeleteShopItemUseCase,
    private val addUseCase: AddShopItemUseCase
) : ViewModel() {

    fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(getShopListUseCase.getShopList()) { list -> list.sortedByDescending { it.isActive } }

    fun addShopItem(item: ShopItem) = viewModelScope.launch { addUseCase.addShopItem(item) }

    fun editShopItem(item: ShopItem) = viewModelScope.launch { editUseCase.editShopItem(item) }

    fun changedEnabledState(item: ShopItem) =
        viewModelScope.launch { editUseCase.editShopItem(item.copy(isActive = !item.isActive)) }

    fun deleteShopItem(item: ShopItem) =
        viewModelScope.launch { deleteUseCase.deleteShopItem(item) }
}