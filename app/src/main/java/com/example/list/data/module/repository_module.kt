package com.example.list.data.module

import com.example.list.data.repository.ShopItemRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module { single { ShopItemRepositoryImpl(get(), get()) } }