package com.example.sdui.ui.map.modifier

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier

internal fun Modifier.mapVerticalScroll(
    isScroll: Boolean?,
    state: ScrollState,
): Modifier =
    if (isScroll != null) {
        this.verticalScroll(state, isScroll)
    } else {
        this
    }

internal fun Modifier.mapHorizontalScroll(
    isScroll: Boolean?,
    state: ScrollState,
): Modifier =
    if (isScroll != null) {
        this.horizontalScroll(state, isScroll)
    } else {
        this
    }
