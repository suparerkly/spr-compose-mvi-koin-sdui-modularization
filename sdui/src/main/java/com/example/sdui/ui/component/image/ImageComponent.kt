package com.example.sdui.ui.component.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.enumclass.mapContentScale
import com.example.sdui.ui.map.modifier.mapRatio
import com.example.sdui.ui.map.modifier.mapSize
import com.example.sdui.utils.extentions.shimmer

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    component: Component.Image
) {
    AppAsyncImage(
        url = component.url,
        contentScale = component.contentScale.mapContentScale(),
        loading = {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .shimmer(),
            )
        },
        modifier =
        modifier
            .mapSize(component.width, component.height, component.style, component.ratio)
            .mapRatio(component.ratio)
    )
}
