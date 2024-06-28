package com.example.data.di

import com.example.data.repository.HomeBannerRepositoryImpl
import org.koin.dsl.module

val homeModule = module {
    factory { HomeBannerRepositoryImpl(get()) }
}