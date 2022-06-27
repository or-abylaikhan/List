package com.example.list

import android.app.Application
import com.example.list.data.databaseModule
import com.example.list.data.repositoryModule
import com.example.list.domain.useCaseModule
import com.example.list.presentation.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            val appModule = listOf(databaseModule, repositoryModule, useCaseModule, viewModelModule)
            modules(appModule)
            androidContext(this@ListApp)
        }
    }
}