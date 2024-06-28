package com.example.sdui.ui.map.enumclass

import androidx.compose.ui.layout.ContentScale
import com.example.sdui.data.model.enumclass.ComponentContentScale

internal fun ComponentContentScale?.mapContentScale(): ContentScale =
    if (this != null) {
        when (this) {
            ComponentContentScale.FILL -> ContentScale.FillBounds
            ComponentContentScale.CROP -> ContentScale.Crop
        }
    } else {
        ContentScale.FillBounds
    }
