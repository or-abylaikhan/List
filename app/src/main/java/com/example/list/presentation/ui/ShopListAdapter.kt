package com.example.list.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.list.databinding.ItemShopDisabledBinding
import com.example.list.databinding.ItemShopEnabledBinding
import com.example.list.domain.model.ShopItem

class ShopListAdapter :
    ListAdapter<ShopItem, ShopListAdapter.ShopItemViewHolder>(ShopItemDiffCallBack()) {
    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
    }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder =
        ShopItemViewHolder(
            if (viewType == ENABLED)
                ItemShopEnabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            else
                ItemShopDisabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int) =
        if (getItem(position).isActive) ENABLED else DISABLED

    inner class ShopItemViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) {
            when (binding) {
                is ItemShopEnabledBinding -> {
                    binding.apply {
                        itemName.text = shopItem.name
                        itemCount.text = shopItem.count.toString()
                        itemDesc.text = shopItem.description
                        root.setOnClickListener { onShopItemClickListener?.invoke(shopItem) }
                        root.setOnLongClickListener { onShopItemLongClickListener?.invoke(shopItem); true }
                    }
                }
                is ItemShopDisabledBinding -> {
                    binding.apply {
                        itemName.text = shopItem.name
                        itemCount.text = shopItem.count.toString()
                        itemDesc.text = shopItem.description
                        root.setOnClickListener { onShopItemClickListener?.invoke(shopItem) }
                        root.setOnLongClickListener { onShopItemLongClickListener?.invoke(shopItem); true }
                    }
                }
            }
        }
    }
}