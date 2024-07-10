package com.marosalvsoftware.myp.navgraph

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marosalvsoftware.myp.screens.AddBetScreen
import com.marosalvsoftware.myp.screens.HistoryScreen
import com.marosalvsoftware.myp.screens.HomeScreen
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.screens.SettingsScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    context : Context
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route=Screen.Home.route){HomeScreen(navController, context)}
        composable(route=Screen.Settings.route){SettingsScreen(navController, context)}
        composable(route=Screen.AddBet.route){AddBetScreen(navController, context)}
        composable(route=Screen.History.route){HistoryScreen(navController, context)}
    }
}
