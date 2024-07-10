package com.marosalvsoftware.myp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.MySettings
import com.marosalvsoftware.myp.navgraph.BottomNavGraph


@Composable
fun MainView(modifier: Modifier = Modifier, context : Context){
    val navController = rememberNavController()

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navController = navController)})
    { innerPadding ->
        BottomNavGraph(navController = navController, paddingValues = innerPadding, context = context)
    }
}

@Composable
fun BottomBar(navController: NavHostController)
{
    val screens = listOf(
        Screen.AddBet,
        Screen.History,
        Screen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar (
        modifier = Modifier.height(MySettings.NavigationBarSettings.heightDp),
        containerColor = MySettings.ColorThemeLight.primary,
        contentColor = contentColorFor(backgroundColor = MySettings.ColorThemeLight.primary)

        ){
        screens.forEach{
            screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
                )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController){
    NavigationBarItem(
        label = {Text(screen.name)},
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            if (currentDestination?.route != Screen.Home.route) navController.popBackStack()
            navController.navigate(screen.route)
                  },
        icon = { Icon(imageVector = screen.icon, contentDescription = screen.description)},
        colors = NavigationBarItemColors
            (
                selectedIndicatorColor = MySettings.ColorThemeLight.secondary,
                unselectedIconColor = MySettings.ColorThemeLight.icons,
                selectedIconColor = MySettings.ColorThemeLight.tertiary,
                unselectedTextColor = MySettings.ColorThemeLight.icons,
                disabledTextColor = MySettings.ColorThemeLight.icons,
                disabledIconColor = MySettings.ColorThemeLight.icons,
                selectedTextColor = MySettings.ColorThemeLight.tertiary
            )
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewMainView(){
    MainView(Modifier, LocalContext.current)
}