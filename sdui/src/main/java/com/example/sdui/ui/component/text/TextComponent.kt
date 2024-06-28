package com.example.sdui.ui.component.text

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sdui.data.model.component.Component

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    component: Component.Text,
    data: Map<String, Any?>? = null
) {
    Text(component.text ?: "", modifier = modifier.size(component.size?.dp ?: 10.dp))
}
