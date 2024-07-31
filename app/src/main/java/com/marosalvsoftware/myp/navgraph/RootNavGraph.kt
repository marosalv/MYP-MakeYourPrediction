package com.marosalvsoftware.myp.navgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.screens.AddBetScreen
import com.marosalvsoftware.myp.screens.HistoryScreen
import com.marosalvsoftware.myp.screens.HomeScreen
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.screens.SettingsScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    activity: MainActivity
) {
    NavHost(navController = navController,
        startDestination = "root",
        enterTransition = {
            fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(100))
        }) {
        navigation(startDestination = Screen.Home.route, route = "root") {
            composable(route = Screen.Home.route) {
                if(false) { //TODO check if user is logged in on splashScreen during the loading screen
                    navController.navigate("auth")
                }
                else {
                    HomeScreen(navController, activity)
                }
            }
        }

        navigation(startDestination = Screen.Home.route, route = "main") {
            composable(route = Screen.Home.route) { HomeScreen(navController, activity) }
            composable(route = Screen.Settings.route) { SettingsScreen(navController, activity) }
            composable(route = Screen.AddBet.route) { AddBetScreen(navController, activity) }
            composable(route = Screen.History.route) { HistoryScreen(navController, activity) }
        }

        navigation(startDestination = "login", route = "auth") {
            composable(route = "login") {}//TODO add login screen
            composable(route = "register") {}//TODO add register screen
            composable(route = "forgot") {}//TODO add forgot screen
        }
    }
}