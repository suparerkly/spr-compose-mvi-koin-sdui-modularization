package com.example.sdui.ui.component.lazycolumn

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component

@Composable
fun LazyColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.LazyColumn,
    data: Map<String, Any?>? = null
) {
    LazyColumn {
        items(component.body ?: emptyList()) { component ->
            AppUiComponent(
                component = component,
                data = data
            )
        }
    }
}
