package com.example.data.usecase

import com.example.core.model.home.HomeResultModel
import com.example.core.utils.NetworkResult
import com.example.data.repository.homeScreenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoadHomeScreenUseCase @Inject constructor(
    private val repository: homeScreenRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {

    private var homeScreenDetail = HomeResultModel()

    suspend operator fun invoke(): Flow<NetworkResult<HomeResultModel>> =
        flow {
            try {
                emit(NetworkResult.Loading(true))
                homeScreenDetail = repository.getHomeScreen()
                emit(NetworkResult.Success(homeScreenDetail))
            } catch (e: Throwable) {
                emit(NetworkResult.Failure(e.message ?: ""))
            }
        }.flowOn(defaultDispatcher)
}