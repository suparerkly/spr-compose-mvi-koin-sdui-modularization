package com.example.sprkoinmodelization.android.presentation.navigation.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.features.ui.initHomeScreen

@Composable
fun HomeScreenUI() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "firstscreen"
    ) {
        composable("firstscreen") {
            initHomeScreen()
        }
        composable("secondscreen"){
        }
    }
}
