package com.example.list.data.module

import com.example.list.data.ShopItemRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module { single { ShopItemRepositoryImpl(get(), get()) } }