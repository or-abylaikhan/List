package com.example.list.data.module

import com.example.list.data.ShopItemMapper
import org.koin.dsl.module

val mapperModule = module { factory { ShopItemMapper() } }