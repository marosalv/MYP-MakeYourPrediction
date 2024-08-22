package com.marosalvsoftware.myp.navgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marosalvsoftware.firebase_signin.online.firebase.FirebaseManager
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.screens.main.AddBetScreen
import com.marosalvsoftware.myp.screens.main.HistoryScreen
import com.marosalvsoftware.myp.screens.main.HomeScreen
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.screens.main.SettingsScreen
import com.marosalvsoftware.myp.screens.auth.ForgotScreen
import com.marosalvsoftware.myp.screens.auth.LoginScreen
import com.marosalvsoftware.myp.screens.auth.RegisterScreen

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

        navigation(startDestination = Screen.Home.route, route = ROOT_ROUTE) {
            composable(route = Screen.Home.route) {
                if(!FirebaseManager().isUserSignedIn()) {
                    LoginScreen(navController = navController)
                }
                else {
                    HomeScreen(navController, activity)
                }
            }
        }

        navigation(startDestination = Screen.Home.route, route = MAIN_ROUTE) {
            composable(route = Screen.Home.route) {         HomeScreen(navController, activity) }
            composable(route = Screen.Settings.route) {     SettingsScreen(navController, activity) }
            composable(route = Screen.AddBet.route) {       AddBetScreen(navController, activity) }
            composable(route = Screen.History.route) {      HistoryScreen(navController, activity) }
        }

        navigation(startDestination = Screen.Login.route, route = AUTH_ROUTE) {
            composable(route = Screen.Login.route) {        LoginScreen(navController = navController)}//TODO add login screen
            composable(route = Screen.Register.route) {     RegisterScreen(navController = navController)}//TODO add register screen
            composable(route = Screen.Forgot.route) {       ForgotScreen(navController = navController)}//TODO add forgot screen
        }
    }
}

const val MAIN_ROUTE : String = "main"
const val ROOT_ROUTE : String = "root"
const val AUTH_ROUTE : String = "auth"