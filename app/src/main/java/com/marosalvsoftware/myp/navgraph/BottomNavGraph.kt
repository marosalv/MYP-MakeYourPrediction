package com.marosalvsoftware.myp.navgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.screens.AddBetScreen
import com.marosalvsoftware.myp.screens.HistoryScreen
import com.marosalvsoftware.myp.screens.HomeScreen
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.screens.SettingsScreen

/**
 * Unused for now. Might be useful in the future to nest the navGraphs.
 */
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    activity: MainActivity
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(100))
        }) {
        composable(route=Screen.Home.route){HomeScreen(navController, activity)}
        composable(route=Screen.Settings.route){SettingsScreen(navController, activity)}
        composable(route=Screen.AddBet.route){AddBetScreen(navController, activity)}
        composable(route=Screen.History.route){HistoryScreen(navController, activity)}
    }
}
