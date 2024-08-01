package com.marosalvsoftware.myp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val name: String,
    val route: String,
    val description: String,
    val icon: ImageVector
) {
    data object Home : Screen(
        name = "Home",
        route = "home",
        description = "Home Screen",
        icon = Icons.Outlined.Home
    )
    data object Settings: Screen(
        name = "Settings",
        route = "settings",
        description = "MySettings Screen",
        icon = Icons.Default.Settings
    )
    data object AddBet: Screen(
        name = "Add Bet",
        route = "add_bet",
        description = "Add Bet Screen",
        icon = Icons.Default.Add
    )
    data object History: Screen(
        name = "History",
        route = "history",
        description = "History Screen",
        icon = Icons.AutoMirrored.Filled.List
    )
    data object Profile: Screen(
        name = "Profile",
        route = "profile",
        description = "Profile Screen",
        icon = Icons.Default.Settings
    )
    data object Login: Screen(
        name = "Login",
        route = "login",
        description = "Login Screen",
        icon = Icons.Filled.AccountBox
    )
    data object Register: Screen(
        name = "Register",
        route = "register",
        description = "Register Screen",
        icon =Icons.Outlined.AccountBox
    )
    data object Forgot: Screen(
        name = "Forgot",
        route = "forgot",
        description = "Forgot Screen",
        icon = Icons.Outlined.AccountCircle
    )
}