package com.example.features.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.home.HomeResultModel
import com.example.core.model.sdui.Body
import com.example.core.model.sdui.SduiModel
import com.example.core.utils.NetworkResult
import com.example.data.repository.HomeBannerRepositoryImpl
import com.example.features.R
import com.example.features.state.BannerUiState
import com.example.features.state.ComponentTestState
import com.example.features.state.HomeBannerUiState
import com.example.sdui.data.di.remote.SduiRemoteDatasourceImpl
import com.example.sdui.data.model.component.Component
import com.example.sdui.utils.MoshiUtil
import com.example.sdui.utils.extentions.fromJsonComponent
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val context: Context,
    private val homeScreenRepository: HomeBannerRepositoryImpl
) : ViewModel() {

    private val _homeTestUiState = MutableStateFlow(HomeResultModel())
    val homeTestUiState: StateFlow<HomeResultModel> get() = _homeTestUiState

    private val _homeBannerUiState = MutableStateFlow(HomeBannerUiState())
    val homeBannerUiState: StateFlow<HomeBannerUiState> get() = _homeBannerUiState

    private val _loadingUiState = MutableStateFlow(true)
    val loadingUiState: StateFlow<Boolean> get() = _loadingUiState

    private val _componentTest = MutableStateFlow(ComponentTestState())
    val componentTest: StateFlow<ComponentTestState> get() = _componentTest

    init {
//        getHomeScreen()
        getSduiScreen()
    }

    fun getSduiScreen() {
        viewModelScope.launch {
            try {
                homeScreenRepository.getSduiTest().collect { resources ->
                    when (resources) {
                        is NetworkResult.Success -> {
                            _loadingUiState.update {
                                false
                            }
                            val component = getImageComponent()
                            _componentTest.update {
                                ComponentTestState(component)
                            }
                        }

                        is NetworkResult.Failure -> {
                            _loadingUiState.update {
                                false
                            }
                        }

                        is NetworkResult.Loading -> {
                            _loadingUiState.update {
                                true
                            }
                        }
                    }
                }
            } catch (ex: Exception) {

            }
        }
    }

    fun getImageComponent(): Component =
        context.resources.openRawResource(R.raw.image).bufferedReader()
            .use { it.readText() }
            .fromJsonComponent()
            ?: Component.Unknown

    fun test() {
        context.resources
            .openRawResource(R.raw.image)
            .bufferedReader()
            .use { it.readText() }
            .fromJsonComponent()
    }

    fun getHomeScreen() {
        viewModelScope.launch {
            try {
                homeScreenRepository.getHomeBanner().collect { resources ->
                    when (resources) {
                        is NetworkResult.Success -> {
//                            val listBanner = resources.data.data?.layout?.filter { data ->
//                                data.type == "banner"
//                            }
                            _loadingUiState.update {
                                false
                            }
                            _homeBannerUiState.update {
                                HomeBannerUiState(resources.data)
                            }
                        }

                        is NetworkResult.Failure -> {
                            _loadingUiState.update {
                                false
                            }
                            Log.d("Network Error", "network api failure")
                        }

                        is NetworkResult.Loading -> {
                            _loadingUiState.update {
                                true
                            }
                            Log.d("Network Error", "network api failure")
                        }
                    }
                }
            } catch (ex: Exception) {
                Log.d("exception", "ERROR EXCEPTION")
            }
        }
    }
}