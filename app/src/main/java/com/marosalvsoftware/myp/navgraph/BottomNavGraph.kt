package com.marosalvsoftware.myp.navgraph

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

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    activity: MainActivity
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route=Screen.Home.route){HomeScreen(navController, activity, paddingValues)}
        composable(route=Screen.Settings.route){SettingsScreen(navController, activity, paddingValues)}
        composable(route=Screen.AddBet.route){AddBetScreen(navController, activity)}
        composable(route=Screen.History.route){HistoryScreen(navController, activity)}
    }
}
