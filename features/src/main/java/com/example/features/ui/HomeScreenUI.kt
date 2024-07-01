package com.example.features.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.core.model.home.dataResult
import com.example.features.viewmodel.HomeViewModel
import com.example.sdui.data.model.component.AppUiComponent
import com.example.sdui.data.model.component.Component
import org.koin.androidx.compose.koinViewModel

@Composable
fun initHomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val loadingUiState = viewModel.loadingUiState.collectAsState()

    var loading by remember { mutableStateOf(false) }

    loading = loadingUiState.value

    if (loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            lottieCloseExample(
                modifier = Modifier
                    .size(200.dp)
            )
        }
    } else {
        horizontalTest()
//        test()
    }
}

@Composable
fun lottieCloseExample(modifier: Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(com.example.features.R.raw.animation_loading)
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = 1,
        isPlaying = true,
    )

    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier,
        alignment = Alignment.Center
    )
}

@Composable
fun HomeScreenUI() {
    val viewModel = koinViewModel<HomeViewModel>()
    val homeScreen = viewModel.homeBannerUiState.collectAsState()

//    var type by remember { mutableStateOf("column") }
//    if (homeScreen.value != null) {
//        type = homeScreen.value.data?.type ?: ""
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
//        initHomePageDetail(homeScreen.value.data?.data ?: listOf())
    }

//    val pagerState =
//        rememberPagerState(pageCount = {
//            homeScreen.value.data ?: 0
//        })
//
//    Column(
//        modifier =
//        Modifier
//            .padding(horizontal = 8.dp)
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//    ) {
//        HorizontalPager(state = pagerState) { page ->
//            imagePngJpgUI(image = homeScreen.value.data?.get(page)?.image ?: "")
//        }
//    }
}

@Composable
fun initHomePageDetail(list: List<dataResult>) {
    list.forEach {
        if (it.type_data == "row") {
            LazyRow {
                items(it.img?.size ?: 0) { index ->
//                    imagePngJpgUI(image = it.img?.get(index) ?: "")
                }
            }
        } else {
            LazyColumn {
                items(it.img?.size ?: 0) { index ->
//                    imagePngJpgUI(image = it.img?.get(index) ?: "")
                }
            }
        }
    }
}

//@Composable
//fun UiTest() {
//    val viewModel = koinViewModel<HomeViewModel>()
//    val homeBannerState = viewModel.homeBannerUiState.collectAsState()
//
//    var logo by remember { mutableStateOf(listOf<LogoItem>()) }
//
//    logo = homeBannerState.value.data?.data?.logo ?: listOf()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        Row(
//            modifier =
//            Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth(),
//        ) {
//            logo.forEach {
//                if (it.type == "square") {
//                    imageUI(image = it.image ?: "", sizeImg = 30)
//                } else if (it.type == "rectangle") {
//                    imageSvgUI(image = it.image ?: "")
//                }
//            }
//            buttonLogin()
//        }
//    }
//}

@Composable
fun test() {
//    horizontalTest()
    val viewModel = koinViewModel<HomeViewModel>()
    val componentTest = viewModel.componentTest.collectAsState()

    AppUiComponent(component = componentTest.value.data ?: Component.Unknown)
}


@Composable
fun horizontalTest() {
    Column {
        val pagerState = rememberPagerState(pageCount = {
            4
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
                    model = "https://ott-picture.bugaboo.tv/5295f706-5432-41b9-b108-aed0d81e33e0693586789710418060-l.jpeg",
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
            repeat(4) { iteration ->
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

}