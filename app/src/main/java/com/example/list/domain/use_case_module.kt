package com.example.list.domain

import com.example.list.domain.use_cases.*
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