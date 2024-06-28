package com.example.sdui.ui.component.rowcolumn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component

@Composable
fun RowColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.RowColumn,
    data: Map<String, Any?>? = null
) {
    Row {
        component.list?.forEach { component ->
            AppUiComponent(
                component = component,
                data = data
            )
        }
    }
}
