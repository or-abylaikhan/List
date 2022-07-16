package com.example.list.data.module

import com.example.list.data.mapper.ShopItemMapper
import org.koin.dsl.module

val mapperModule = module { single { ShopItemMapper() } }