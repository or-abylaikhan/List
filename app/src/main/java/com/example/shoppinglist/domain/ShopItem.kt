package com.example.shoppinglist.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val count: Int,
    val isEnabled: Boolean
)