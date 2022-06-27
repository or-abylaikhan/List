package com.example.list.data

import com.example.list.domain.ShopItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ShopItemRepository>() {
        ShopItemRepositoryImpl(get(), get())
    }
    single {
        ShopItemMapper()
    }
}