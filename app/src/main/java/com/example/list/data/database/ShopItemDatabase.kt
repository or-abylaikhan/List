package com.example.list.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.list.data.ShopItemDbModel

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class ShopItemDatabase : RoomDatabase() {
    abstract fun shopItemDao(): ShopItemDao
}