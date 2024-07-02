package com.example.core.api.home

import com.example.core.model.home.HomeResultModel
import com.example.core.model.sdui.SduiModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface HomeAPIInterface {
//    @GET("home")
//    suspend fun getHomeResults(
//    ): HomeResultModel

    @GET("84c0cdc7-63b9-4232-aa05-0a1399f0f1af")
    suspend fun getHomeResults(
    ): HomeResultModel

    @GET("sduiMock")
    suspend fun getSduiTest(
    ): JsonObject

}
