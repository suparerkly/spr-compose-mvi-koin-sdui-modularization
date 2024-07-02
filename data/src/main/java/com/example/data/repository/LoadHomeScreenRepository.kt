package com.example.data.repository

import com.example.core.api.home.HomeAPIInterface
import com.example.core.model.home.HomeResultModel
import javax.inject.Inject

class homeScreenRepository @Inject constructor(
    private val apiService: HomeAPIInterface,
) {
    suspend fun getHomeScreen(): HomeResultModel = apiService.getHomeResults()
}