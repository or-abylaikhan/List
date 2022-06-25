package com.example.shoppinglist.domain.module

import com.example.shoppinglist.domain.*
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetShopItemUseCase(get())
    }
    factory {
        GetShopListUseCase(get())
    }
    factory {
        AddShopItemUseCase(get())
    }
    factory {
        EditShopItemUseCase(get())
    }
    factory {
        DeleteShopItemUseCase(get())
    }
}