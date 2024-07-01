package com.example.sdui.ui.component.lazyrow

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component

@Composable
fun LazyRowComponent(
    modifier: Modifier = Modifier,
    component: Component.LazyRow
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(component.body ?: emptyList()) { component ->
            AppUiComponent(
                component = component,
                modifier = modifier
            )
        }
    }
}
