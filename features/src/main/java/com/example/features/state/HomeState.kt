package com.example.features.state

import com.example.core.model.home.Home
import com.example.core.model.home.HomeResultModel
import com.example.sdui.data.model.component.Component

data class HomeBannerUiState(
    val data: HomeResultModel? = null,
    val message: String? = null
)

data class BannerUiState(
    val data: Home? = null,
    val message: String? = null
)

data class ComponentTestState(
    val data: Component? = null,
    val message: String? = null
)