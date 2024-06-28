package com.example.sprkoinmodelization.android.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.sdui.ui.component.video.VideoPlayer
import com.example.sprkoinmodelization.android.presentation.navigation.Screen
import com.example.sprkoinmodelization.android.presentation.ui.home.HomeScreenUI
import com.example.sprkoinmodelization.android.presentation.ui.sdui.SduiScreenUI
import com.example.sprkoinmodelization.ui.theme.NavigationSuiteLayoutGuideTheme

class MainScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSuiteLayoutGuideTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var selectedItemIndex by remember {
                        mutableStateOf(Screen.HOME)
                    }
                    val windowWidthClass =
                        currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
                    NavigationSuiteScaffold(
                        navigationSuiteItems = {
                            Screen.entries.forEachIndexed { index, screen ->
                                item(
                                    selected = screen == selectedItemIndex,
                                    onClick = {
                                        selectedItemIndex = screen
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = screen.icon,
                                            contentDescription = screen.title
                                        )
                                    },
                                    label = {
                                        Text(text = screen.title)
                                    }
                                )
                            }
                        },
                        layoutType = if (windowWidthClass == WindowWidthSizeClass.EXPANDED) {
                            NavigationSuiteType.NavigationDrawer
                        } else {
                            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
                                currentWindowAdaptiveInfo()
                            )
                        }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Screen.entries.forEachIndexed { index, screen ->
                                when (selectedItemIndex) {
                                    Screen.HOME -> {
                                        HomeScreenUI()
                                    }

                                    Screen.SDUI -> {
                                        SduiScreenUI()
                                    }

                                    Screen.VIDEO -> {
                                        VideoPlayer(this@MainScreenActivity)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}