package com.example.sdui.utils.extentions

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.IntSize
import androidx.core.app.NotificationCompat.*

internal fun Modifier.clickable(
    action: Action?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: (Action) -> Unit,
): Modifier =
    if (action != null) {
        this.clickable(
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            onClick = {
                onClick(action)
            },
        )
    } else {
        this
    }

fun Modifier.shimmer(): Modifier =
    composed {
        var size by remember { mutableStateOf(IntSize.Zero) }
        val transition = rememberInfiniteTransition()
        val startOffsetX by transition.animateFloat(
            initialValue = -2 * size.width.toFloat(),
            targetValue = 2 * size.width.toFloat(),
            animationSpec =
            infiniteRepeatable(
                animation = tween(1000),
            )
        )

        this
            .background(
                brush =
                Brush.linearGradient(
                    colors =
                    listOf(
                        Color(0xFFB8B5B5),
                        Color(0xFF8F8B8B),
                        Color(0xFFB8B5B5),
                    ),
                    start = Offset(startOffsetX, 0f),
                    end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
                ),
            ).onGloballyPositioned {
                size = it.size
            }
    }
