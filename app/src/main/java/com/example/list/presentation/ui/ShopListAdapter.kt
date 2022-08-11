package com.example.list.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.list.databinding.ItemShopDisabledBinding
import com.example.list.databinding.ItemShopEnabledBinding
import com.example.list.domain.model.ShopItem
import com.example.list.util.Constants.DISABLED
import com.example.list.util.Constants.ENABLED

class ShopListAdapter(
    private var onShopItemLongClickListener: ((ShopItem) -> Unit),
    private var onShopItemClickListener: ((ShopItem) -> Unit)
) : ListAdapter<ShopItem, ShopListAdapter.ShopItemViewHolder>(
    object : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(old: ShopItem, new: ShopItem) = old.id == new.id
        override fun areContentsTheSame(old: ShopItem, new: ShopItem) = old == new
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder =
        ShopItemViewHolder(
            if (viewType == ENABLED)
                ItemShopEnabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            else
                ItemShopDisabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) =
        holder.bind(getItem(position))


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
                        root.setOnClickListener { onShopItemClickListener.invoke(shopItem) }
                        root.setOnLongClickListener { onShopItemLongClickListener.invoke(shopItem); true }
                    }
                }
                is ItemShopDisabledBinding -> {
                    binding.apply {
                        itemName.text = shopItem.name
                        itemCount.text = shopItem.count.toString()
                        itemDesc.text = shopItem.description
                        root.setOnClickListener { onShopItemClickListener.invoke(shopItem) }
                        root.setOnLongClickListener { onShopItemLongClickListener.invoke(shopItem); true }
                    }
                }
            }
        }
    }
}