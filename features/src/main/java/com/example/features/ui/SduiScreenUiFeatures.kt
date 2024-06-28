package com.example.features.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.features.viewmodel.HomeViewModel
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component
import org.koin.androidx.compose.koinViewModel

@Composable
fun SduiFeatures() {
    val viewModel = koinViewModel<HomeViewModel>()
    val componentTest = viewModel.componentTest.collectAsState()

    AppUiComponent(component = componentTest.value.data ?: Component.Unknown)
}