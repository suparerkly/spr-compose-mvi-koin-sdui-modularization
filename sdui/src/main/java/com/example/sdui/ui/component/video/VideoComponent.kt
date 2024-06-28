package com.example.sdui.ui.component.video

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.analytics.AnalyticsListener
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.cache.VideoPlayerCacheManager
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem


@Composable
fun VideoPlayer(context: Context) {
    VideoPlayerCacheManager.initialize(context, 1024 * 1024 * 1024)    // 1GB
    VideoPlayer(
        mediaItems = listOf(
//            VideoPlayerMediaItem.RawResourceMediaItem(
//                resourceId = R.raw.movie1,
//            ),
//            VideoPlayerMediaItem.AssetFileMediaItem(
//                assetPath = "videos/test.mp4"
//            ),
//            VideoPlayerMediaItem.StorageMediaItem(
//                storageUri = Uri.parse("https://www.youtube.com/watch?v=rHcdvGUNf-I")
//            ),
            VideoPlayerMediaItem.NetworkMediaItem(
                url = "https://storage.googleapis.com/wvmedia/cbcs/h264/tears/tears_aes_cbcs.mpd",
                mediaMetadata = MediaMetadata.Builder().setTitle("Widevine DASH cbcs: Tears")
                    .build(),
                mimeType = MimeTypes.APPLICATION_MPD,
                drmConfiguration = MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
                    .setLicenseUri("https://proxy.uat.widevine.com/proxy?provider=widevine_test")
                    .build(),
            )
        ),
        handleLifecycle = true,
        autoPlay = true,
        usePlayerController = true,
        enablePip = true,
        handleAudioFocus = true,
        controllerConfig = VideoPlayerControllerConfig(
            showSpeedAndPitchOverlay = false,
            showSubtitleButton = false,
            showCurrentTimeAndTotalTime = true,
            showBufferingProgress = false,
            showForwardIncrementButton = true,
            showBackwardIncrementButton = true,
            showBackTrackButton = true,
            showNextTrackButton = true,
            showRepeatModeButton = true,
            controllerShowTimeMilliSeconds = 5_000,
            controllerAutoShow = true,
            showFullScreenButton = true
        ),
        volume = 0.5f,  // volume 0.0f to 1.0f
        repeatMode = RepeatMode.NONE,       // or RepeatMode.ALL, RepeatMode.ONE
        onCurrentTimeChanged = { // long type, current player time (millisec)
            Log.e("CurrentTime", it.toString())
        },
        playerInstance = { // ExoPlayer instance (Experimental)
            addAnalyticsListener(
                object : AnalyticsListener {
                    // player logger
                }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    )
}