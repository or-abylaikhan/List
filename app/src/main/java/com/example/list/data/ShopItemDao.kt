package com.example.list.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getAll(): LiveData<List<ShopItemDbModel>>

    @Query("SELECT * FROM shop_items WHERE id = :id")
    suspend fun getShopItem(id: Int): ShopItemDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShopItem(item: ShopItemDbModel)

    @Update
    suspend fun updateShopItem(item: ShopItemDbModel)

    @Delete
    suspend fun deleteShopItem(item: ShopItemDbModel)
}