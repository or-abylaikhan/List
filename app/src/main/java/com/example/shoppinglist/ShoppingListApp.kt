package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.data.module.databaseModule
import com.example.shoppinglist.data.module.repositoryModule
import com.example.shoppinglist.domain.module.useCaseModule
import com.example.shoppinglist.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShoppingListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ShoppingListApp)
            modules(databaseModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}