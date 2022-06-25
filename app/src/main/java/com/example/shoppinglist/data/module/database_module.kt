package com.example.shoppinglist.data.module

import android.content.Context
import androidx.room.Room
import com.example.shoppinglist.data.ShopItemDatabase
import com.example.shoppinglist.util.AppConstants.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        provideDataBase(androidContext())
    }
    single {
        provideShopItemDao(get())
    }
}

fun provideDataBase(applicationContext: Context) =
    Room.databaseBuilder(applicationContext, ShopItemDatabase::class.java, DATABASE_NAME).build()

fun provideShopItemDao(database: ShopItemDatabase) = database.shopItemDao()