package com.example.sdui.data.model.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.ui.component.column.ColumnComponent
import com.example.sdui.ui.component.image.ImageComponent
import com.example.sdui.ui.component.lazycolumn.LazyColumnComponent
import com.example.sdui.ui.component.rowcolumn.RowColumnComponent
import com.example.sdui.ui.component.text.TextComponent

@Composable
fun AppUiComponent(
    modifier: Modifier = Modifier,
    component: Component,
    data: Map<String, Any?>? = null
) {
    when (component) {
        is Component.LazyColumn -> {
            LazyColumnComponent(
                modifier,
                component,
            )
        }

        is Component.Image -> {
            ImageComponent(component = component, modifier = modifier)
        }

        is Component.Column -> {
            ColumnComponent(component = component, modifier = modifier)
        }

        is Component.RowColumn -> {
            RowColumnComponent(component = component, modifier = modifier)
        }

        is Component.Text -> {
            TextComponent(component = component, modifier = modifier)
        }

        Component.Unknown -> {
            Box(modifier)
        }
    }
}
