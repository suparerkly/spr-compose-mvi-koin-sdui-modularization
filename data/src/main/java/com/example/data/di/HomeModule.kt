package com.example.data.di

import com.example.data.repository.HomeBannerRepository
import org.koin.dsl.module

val homeModule = module {
    factory { HomeBannerRepository(get()) }
}