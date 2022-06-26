package com.example.shoppinglist.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.model.ShopItem

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getAll(): LiveData<List<ShopItem>>

    @Query("SELECT * FROM shop_items WHERE id = :id")
    fun getShopItem(id: Int): ShopItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShopItem(item: ShopItem)

    @Update
    fun updateShopItem(item: ShopItem)

    @Delete
    fun deleteShopItem(item: ShopItem)
}