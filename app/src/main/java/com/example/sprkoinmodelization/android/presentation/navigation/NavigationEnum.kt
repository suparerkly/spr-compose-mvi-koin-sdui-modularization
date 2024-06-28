package com.example.sprkoinmodelization.android.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(val title: String, val icon: ImageVector) {
    HOME("หน้าหลัก", Icons.Default.Home),
    SDUI("SDUI", Icons.Default.Favorite),
    VIDEO("วิดีโอ", Icons.Default.PlayArrow),
}