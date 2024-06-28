package com.example.sdui.ui.component.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageScope
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.sdui.R

@Composable
fun AppAsyncImage(
    url: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    loading: @Composable
    (SubcomposeAsyncImageScope.(AsyncImagePainter.State.Loading) -> Unit)? = null,
    success: @Composable
    (SubcomposeAsyncImageScope.(AsyncImagePainter.State.Success) -> Unit)? = null,
    error: @Composable
    (SubcomposeAsyncImageScope.(AsyncImagePainter.State.Error) -> Unit)? = null,
    onLoading: ((AsyncImagePainter.State.Loading) -> Unit)? = null,
    onSuccess: ((AsyncImagePainter.State.Success) -> Unit)? = null,
    onError: ((AsyncImagePainter.State.Error) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
) {
    if (url != null) {
        SubcomposeAsyncImage(
            model =
            ImageRequest
                .Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .svgDecoder(url)
                .build(),
            contentDescription = contentDescription,
            modifier = modifier,
            loading = loading,
            success = success,
            error = error,
            onLoading = onLoading,
            onSuccess = onSuccess,
            onError = onError,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            filterQuality = filterQuality,
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.place_holder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier,
        )
    }
}

private fun ImageRequest.Builder.svgDecoder(url: String): ImageRequest.Builder {
    val isSvg = url.lowercase().endsWith(".svg")
    return if (isSvg) {
        this.decoderFactory { result, options, _ ->
            SvgDecoder(result.source, options)
        }
    } else {
        this
    }
}
