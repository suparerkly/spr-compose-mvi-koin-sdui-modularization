package com.example.core.di

import com.example.core.api.home.HomeRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://78bfb9d5-9067-4b42-8060-4d1225b238b7.mock.pstmn.io/")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

//fun provideConverterSDUIFactory(): MoshiConverterFactory =
//    MoshiConverterFactory.create(MoshiUtil.getMoshi())
//
//fun provideRetrofitSDUI(
//    okHttpClient: OkHttpClient,
//    moshiConverterFactory: MoshiConverterFactory
//): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl("https://03b0c15d-4069-48f9-bd64-ef872223d1be.mock.pstmn.io/")
//        .client(okHttpClient)
//        .addConverterFactory(moshiConverterFactory)
//        .build()
//}

fun provideService(retrofit: Retrofit): HomeRepository =
    retrofit.create(HomeRepository::class.java)

val networkModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideService(get()) }
}