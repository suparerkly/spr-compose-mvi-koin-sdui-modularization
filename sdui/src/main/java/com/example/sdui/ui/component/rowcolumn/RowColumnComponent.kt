package com.example.sdui.ui.component.rowcolumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.modifier.mapHorizontalSpacing

@Composable
fun RowColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.RowColumn
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = component.spacing.mapHorizontalSpacing()
    ) {
        component.list?.forEach { component ->
            AppUiComponent(
                component = component,
                modifier = modifier,
            )
        }
    }
}
