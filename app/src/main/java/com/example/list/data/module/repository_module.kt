package com.example.list.data.module

import com.example.list.data.repository.ShopItemRepositoryImpl
import com.example.list.domain.repository.ShopItemRepository
import org.koin.dsl.module

val repositoryModule =
    module { single<ShopItemRepository> { ShopItemRepositoryImpl(get(), get()) } }