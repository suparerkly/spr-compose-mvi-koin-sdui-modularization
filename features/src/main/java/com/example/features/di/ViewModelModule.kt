package com.example.features.di

import com.example.features.viewmodel.HomeViewModel
import com.example.features.viewmodel.SduiViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SduiViewModel(get()) }
    viewModel { HomeViewModel(homeScreenRepository = get(), context = get()) }
    viewModelOf(::HomeViewModel)
    viewModelOf(::SduiViewModel)
}