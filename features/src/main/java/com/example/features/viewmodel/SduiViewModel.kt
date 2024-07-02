package com.example.features.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.features.R
import com.example.features.state.ComponentTestState
import com.example.sdui.data.model.component.Component
import com.example.sdui.utils.extentions.fromJsonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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

