package com.example.sdui.ui.map.modifier

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sdui.data.model.enumclass.ComponentContainerStyle

internal fun Modifier.mapSize(
    width: Int?,
    height: Int?,
    containerStyle: ComponentContainerStyle? = null,
    ratio: Float? = null,
): Modifier =
    when {
        width != null && height != null -> {
            this.size(width = width.dp, height = height.dp)
        }

        width != null && height == null -> {
            when (containerStyle) {
                ComponentContainerStyle.AUTO -> {
                    this.width(width.dp)
                }

                ComponentContainerStyle.STRETCH -> {
                    this
                        .width(width.dp)
                        .fillMaxHeight()
                }

                null -> {
                    if (ratio != null) {
                        this.width(width.dp)
                    } else {
                        this
                            .width(width.dp)
                            .fillMaxHeight()
                    }
                }
            }
        }

        width == null && height != null -> {
            when (containerStyle) {
                ComponentContainerStyle.AUTO -> {
                    this.height(height.dp)
                }

                ComponentContainerStyle.STRETCH -> {
                    this
                        .height(height.dp)
                        .fillMaxWidth()
                }

                null -> {
                    if (ratio != null) {
                        this.height(height.dp)
                    } else {
                        this
                            .height(height.dp)
                            .fillMaxWidth()
                    }
                }
            }
        }

        else -> {
            when (containerStyle) {
                ComponentContainerStyle.AUTO -> {
                    this
                }

                ComponentContainerStyle.STRETCH -> {
                    this.fillMaxSize()
                }

                null -> {
                    this
                }
            }
        }
    }
