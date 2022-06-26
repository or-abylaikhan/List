package com.example.shoppinglist.data.module

import com.example.shoppinglist.data.repository.ShopItemRepositoryImpl
import com.example.shoppinglist.domain.repository.ShopItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ShopItemRepository>() {
        ShopItemRepositoryImpl(get())
    }
}