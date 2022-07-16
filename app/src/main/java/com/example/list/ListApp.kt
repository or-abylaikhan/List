package com.example.list

import android.app.Application
import com.example.list.data.module.databaseModule
import com.example.list.data.module.mapperModule
import com.example.list.data.module.repositoryModule
import com.example.list.domain.module.useCaseModule
import com.example.list.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            val appModule = listOf(
                databaseModule,
                repositoryModule,
                mapperModule,
                useCaseModule,
                viewModelModule
            )
            modules(appModule)
            androidContext(this@ListApp)
        }
    }
}