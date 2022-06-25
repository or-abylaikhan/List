package com.example.shoppinglist.data

import androidx.room.*

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getAll(): List<ShopItem>

    @Query("SELECT * FROM shop_items WHERE id = :id")
    fun getShopItem(id: Int): ShopItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShopItem(item: ShopItem)

    @Update
    fun updateShopItem(item: ShopItem)

    @Delete
    fun deleteShopItem(item: ShopItem)
}