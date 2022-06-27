package com.example.list.domain

data class ShopItem(
    val id: Int = 0,
    val name: String,
    val count: Int,
    var isEnabled: Boolean
)