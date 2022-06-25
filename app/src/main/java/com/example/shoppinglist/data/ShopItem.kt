package com.example.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val count: Int,
    val isEnabled: Boolean
)