package com.example.shoppinglist.presentation.module

import com.example.shoppinglist.presentation.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get(), get())
    }
}