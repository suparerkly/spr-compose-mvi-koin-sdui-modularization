package com.example.data.repository

import com.example.core.api.home.HomeRepository
import com.example.core.model.sdui.Body
import com.example.core.utils.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeBannerRepositoryImpl @Inject constructor(private val repository: HomeRepository) {
    suspend fun getSduiTest() = flow {
        emit(NetworkResult.Loading(true))
        val gson = Gson()
        val response = repository.getSduiTest()
        emit(NetworkResult.Success(gson.toJson(response)))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }

    suspend fun getHomeBanner() = flow {
        emit(NetworkResult.Loading(true))
        val response = repository.getHomeResults()
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }
}