package com.example.sdui.ui.map.modifier

import androidx.compose.foundation.layout.Arrangement

internal fun String?.mapHorizontalArrangementStyle(): Arrangement.Horizontal = if(this == "Center") Arrangement.Center else Arrangement.Start

internal fun String?.mapVerticalArrangementStyle(): Arrangement.Vertical = if(this == "Center") Arrangement.Center else Arrangement.Top