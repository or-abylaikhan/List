package com.example.shoppinglist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.database.ShopItemDao
import com.example.shoppinglist.data.model.ShopItem

@Database(entities = [ShopItem::class], version = 1)
abstract class ShopItemDatabase : RoomDatabase() {

    abstract fun shopItemDao(): ShopItemDao
}