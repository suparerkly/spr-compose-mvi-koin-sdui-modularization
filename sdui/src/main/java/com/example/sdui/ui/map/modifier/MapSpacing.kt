package com.example.sdui.ui.map.modifier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp


internal fun Int?.mapHorizontalSpacing(): Arrangement.Horizontal =
    if ((this ?: 0) > 0) Arrangement.spacedBy((this ?: 0).dp) else Arrangement.SpaceBetween
