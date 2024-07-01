package com.example.sdui.ui.component.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.modifier.mapHorizontalAlignmentStyle
import com.example.sdui.ui.map.modifier.mapVerticalArrangementStyle
import com.example.sdui.ui.map.modifier.mapVerticalScroll

@Composable
fun ColumnComponent(
    modifier: Modifier = Modifier, component: Component.Column
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .mapVerticalScroll(component.scroll, rememberScrollState()),
        verticalArrangement = component.arrangement.mapVerticalArrangementStyle(),
        horizontalAlignment = component.alignment.mapHorizontalAlignmentStyle(),
    ) {
        component.list?.forEach { component ->
            AppUiComponent(
                component = component, modifier = modifier
            )
        }
    }
}
