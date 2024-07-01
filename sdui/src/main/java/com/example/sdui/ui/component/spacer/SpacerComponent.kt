package com.example.sdui.ui.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sdui.data.model.component.Component

@Composable
fun SpacerComponent(
    modifier: Modifier = Modifier,
    component: Component.Spacer
) {
    Spacer(modifier = Modifier.height(component.height?.dp ?: 0.dp))
}