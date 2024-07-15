package com.marosalvsoftware.myp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
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
}