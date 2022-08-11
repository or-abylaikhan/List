package com.example.list.domain.model

data class ShopItem(
    val id: Int = 0,
    val name: String,
    val count: Int,
    val description: String,
    var isActive: Boolean = true
)