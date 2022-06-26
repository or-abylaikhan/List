package com.example.shoppinglist.data.module

import android.app.Application
import androidx.room.Room
import com.example.shoppinglist.data.database.ShopItemDatabase
import com.example.shoppinglist.util.Constants.DATABASE_NAME
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        provideDataBase(androidApplication())
    }
    single {
        provideShopItemDao(get())
    }
}

fun provideDataBase(application: Application) =
    Room.databaseBuilder(application, ShopItemDatabase::class.java, DATABASE_NAME).build()

fun provideShopItemDao(database: ShopItemDatabase) = database.shopItemDao()