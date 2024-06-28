package com.example.sdui.data.di.remote

import com.example.sdui.data.di.api.SduiService
import com.example.sdui.data.model.component.Component
import com.example.sdui.utils.MoshiUtil
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SduiRemoteDatasourceImpl(
    private val ioDispatcher: CoroutineDispatcher,
) : SduiRemoteDatasource {
    override suspend fun getSdui(url: String?): Component =
        withContext(ioDispatcher) {
            Retrofit
                .Builder()
                .addConverterFactory(MoshiConverterFactory.create(MoshiUtil.getMoshi()))
                .baseUrl(url)
                .build()
                .create(SduiService::class.java)
                .getSdui(url)
        }
}