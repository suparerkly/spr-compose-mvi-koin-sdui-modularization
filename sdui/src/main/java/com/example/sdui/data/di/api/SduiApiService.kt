package com.example.sdui.data.di.api

import com.example.sdui.data.model.component.Component
import retrofit2.http.GET
import retrofit2.http.Url

internal interface SduiService {
    @GET
    suspend fun getSdui(
        @Url url: String?,
    ): Component
}
