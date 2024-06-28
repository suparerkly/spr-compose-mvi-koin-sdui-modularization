package com.example.data.repository

import com.example.core.utils.NetworkResult
import com.example.sdui.data.di.remote.SduiRemoteDatasource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TestJsonRepositoryImpl @Inject constructor(private val repository: SduiRemoteDatasource) {
    suspend fun getHomeBanner() = flow {
        emit(NetworkResult.Loading(true))
        val response = repository.getSdui("https://b1e0d7f9-963b-4eb3-acd9-0f139050d39e.mock.pstmn.io")
        emit(NetworkResult.Success(response))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }
}