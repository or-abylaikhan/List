package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getAll(): LiveData<List<ShopItemDbModel>>

    @Query("SELECT * FROM shop_items WHERE id = :id")
    fun getShopItem(id: Int): ShopItemDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShopItem(item: ShopItemDbModel)

    @Update
    fun updateShopItem(item: ShopItemDbModel)

    @Delete
    fun deleteShopItem(item: ShopItemDbModel)
}