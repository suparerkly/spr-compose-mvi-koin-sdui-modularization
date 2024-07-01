package com.example.sdui.ui.component.horizontalpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.modifier.mapHorizontalAlignmentStyle
import com.example.sdui.ui.map.modifier.mapVerticalArrangementStyle
import com.example.sdui.ui.map.modifier.mapVerticalScroll

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerComponent(
    modifier: Modifier = Modifier, component: Component.HorizontalPager
) {
    val pagerState = rememberPagerState(pageCount = {
        component.imgList?.size ?: 0
    })
    HorizontalPager(
        state = pagerState
    ) { page ->
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(5.dp)
        ) {
            coil.compose.AsyncImage(
                model = component.imgList?.get(page),
                contentDescription = null
            )
        }
        // Card content

    }


    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(component.imgList?.size ?: 0) { iteration ->
            val color =
                if ((pagerState.currentPage == iteration)) {
                    Color.DarkGray
                } else {
                    Color.LightGray
                }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}
