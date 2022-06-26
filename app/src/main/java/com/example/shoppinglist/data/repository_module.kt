package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ShopItemRepository>() {
        ShopItemRepositoryImpl(get(), get())
    }
    single {
        ShopItemMapper()
    }
}