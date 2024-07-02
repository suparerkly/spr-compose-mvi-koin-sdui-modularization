package com.example.sprkoinmodelization

import android.app.Application
import com.example.core.di.networkModule
import com.example.data.di.homeModule
import com.example.features.di.viewModelModule
import com.example.sdui.data.di.sduiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@App)
            modules(networkModule, homeModule, viewModelModule, sduiModule)
        }
    }
}