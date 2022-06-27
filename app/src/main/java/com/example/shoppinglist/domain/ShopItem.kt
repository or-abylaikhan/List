package com.example.shoppinglist.domain

data class ShopItem(
    val id: Int = 0,
    val name: String,
    val count: Int,
    var isEnabled: Boolean
)