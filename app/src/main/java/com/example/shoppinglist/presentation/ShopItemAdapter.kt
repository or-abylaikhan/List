package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ItemShopBinding
import com.example.shoppinglist.domain.ShopItem

class ShopItemAdapter : RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder>() {

    var shopList: List<ShopItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder =
        ShopItemViewHolder(
            ItemShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount() = shopList.size

    inner class ShopItemViewHolder(private val itemBinding: ItemShopBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(shopItem: ShopItem) {
            itemBinding.apply {
                itemName.text = shopItem.name
                itemCount.text = shopItem.count.toString()
            }
        }
    }
}