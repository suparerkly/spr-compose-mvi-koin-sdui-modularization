package com.example.sdui.ui.component.column

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component

@Composable
fun ColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.Column,
    data: Map<String, Any?>? = null
) {
    Column {
        component.list?.forEach { component ->
            AppUiComponent(
                component = component,
                data = data
            )
        }
    }
}
