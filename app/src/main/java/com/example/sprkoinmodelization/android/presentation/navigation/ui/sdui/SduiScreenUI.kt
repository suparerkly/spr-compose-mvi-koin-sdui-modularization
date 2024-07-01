package com.example.sprkoinmodelization.android.presentation.navigation.ui.sdui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.features.ui.SduiFeatures
import com.example.features.ui.initHomeScreen

@Composable
fun SduiScreenUI() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "firstscreen"
    ) {
        composable("firstscreen") {
            SduiFeatures()
        }
        composable("secondscreen"){
        }
    }
}