package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.shoppinglist.databinding.ItemShopDisabledBinding
import com.example.shoppinglist.databinding.ItemShopEnabledBinding
import com.example.shoppinglist.domain.ShopItem

class ShopItemAdapter : RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder>() {
    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
    }

    var shopList: List<ShopItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder =
        ShopItemViewHolder(
            if (viewType == ENABLED)
                ItemShopEnabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            else
                ItemShopDisabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount() = shopList.size

    override fun getItemViewType(position: Int): Int =
        if (shopList[position].isEnabled) ENABLED else DISABLED


    inner class ShopItemViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopItem: ShopItem) {
            when (binding) {
                is ItemShopEnabledBinding -> {
                    binding.apply {
                        itemName.text = shopItem.name
                        itemCount.text = shopItem.count.toString()
                    }
                }
                is ItemShopDisabledBinding -> {
                    binding.apply {
                        itemName.text = shopItem.name
                        itemCount.text = shopItem.count.toString()
                    }
                }
            }
        }
    }
}