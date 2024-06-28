package com.example.sdui.ui.map.modifier

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.ui.Modifier

internal fun Modifier.mapRatio(ratio: Float?): Modifier =
    if (ratio != null) {
        this.aspectRatio(ratio)
    } else {
        this
    }
