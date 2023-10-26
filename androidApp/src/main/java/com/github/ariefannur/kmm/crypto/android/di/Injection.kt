package com.github.ariefannur.kmm.crypto.android.di

import com.github.ariefannur.kmm.crypto.android.screen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelInjection = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModelOf(::HomeScreenViewModel)
}