package com.example.sdui.ui.map.modifier

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

internal fun String.mapFontWeight(): FontWeight =
    if (this == "Bold") FontWeight.Bold else FontWeight.Normal
