//package com.example.data.di
//
//import android.app.Application
//import com.example.core.di.networkModule
//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin
//import org.koin.core.module.Module
//
//fun initKoin(app: Application) {
//    startKoin {
//        printLogger()
//        androidContext(app)
//        modules(getKoinModules())
//    }
//}
//
//private fun getKoinModules(): List<Module> = listOf(
//    networkModule,
//    HomeModule
//)