package com.example.shoppinglist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val count: Int,
    var isEnabled: Boolean
)