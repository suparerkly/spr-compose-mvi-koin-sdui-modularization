package com.example.sdui.ui.map.modifier

import androidx.compose.ui.Alignment

internal fun String?.mapVerticalAlignmentStyle(): Alignment.Vertical = if(this == "Center") Alignment.CenterVertically else Alignment.Top

internal fun String?.mapHorizontalAlignmentStyle(): Alignment.Horizontal = if(this == "Center") Alignment.CenterHorizontally else Alignment.Start
