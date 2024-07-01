package com.example.sdui.ui.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.modifier.mapFontWeight

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    component: Component.Text
) {
    Text(
        component.text ?: "",
        modifier = modifier
            .padding(component.padding?.dp ?: 0.dp),
        fontSize = component.size?.sp ?: 10.sp,
        fontWeight = component.fontWeight?.mapFontWeight(),
        fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
        color = Color(android.graphics.Color.parseColor(component.hexColor ?: "#888888"))
    )
}
