package com.example.list.presentation.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.list.domain.model.ShopItem

class ShopItemDiffCallBack : DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem) = oldItem == newItem
}