package com.example.shoppinglist.data.module

import com.example.shoppinglist.data.ShopItemRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        ShopItemRepositoryImpl(get())
    }
}