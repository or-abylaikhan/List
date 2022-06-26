package com.example.shoppinglist.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var isEnabled: Boolean,
    val id: Int = 0
)