package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.data.databaseModule
import com.example.shoppinglist.data.repositoryModule
import com.example.shoppinglist.domain.useCaseModule
import com.example.shoppinglist.presentation.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShoppingListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            val appModule = listOf(databaseModule, repositoryModule, useCaseModule, viewModelModule)
            modules(appModule)
            androidContext(this@ShoppingListApp)
        }
    }
}