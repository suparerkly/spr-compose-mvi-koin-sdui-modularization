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

class SduiViewModel @Inject constructor(
    private val context: Context
) : ViewModel() {
    private val _componentTest = MutableStateFlow(ComponentTestState())
    val componentTest: StateFlow<ComponentTestState> get() = _componentTest

    init {
        getSduiScreen()
    }

    fun getSduiScreen() {
        val component = getImageComponent()
        _componentTest.update {
            ComponentTestState(component)
        }
    }

    fun getImageComponent(): Component =
        context.resources.openRawResource(R.raw.image).bufferedReader()
            .use { it.readText() }
            .fromJsonComponent()
            ?: Component.Unknown
}

