package com.marosalvsoftware.myp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.firebase_signin.online.firebase.FirebaseManager
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.settings.MySettings
import com.marosalvsoftware.myp.navgraph.MAIN_ROUTE
import com.marosalvsoftware.myp.navgraph.RootNavGraph
import com.marosalvsoftware.myp.screens.main.toast

@Composable
fun MainView(activity: MainActivity) {

    val navController = rememberNavController()

    RootNavGraph(
        navController = navController,
        activity = activity
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    screen: Screen,
    scrollBehavior: TopAppBarScrollBehavior,
    context: Context,
    navController: NavHostController
) {
    MediumTopAppBar(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        title = {
            Text(
                modifier = Modifier.padding(start = MySettings.Paddings.small),
                text = screen.name,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(MAIN_ROUTE) {
                        inclusive = true
                    }
                }
            }) {
                Image(
                    modifier = Modifier.size(MySettings.Sizes.iconSizes),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = screen.description
                )
            }
        },
        actions = {
            IconButton(onClick = {
                FirebaseManager().signOut()
                {
                    context.toast("User Logged Out")

                    navController.navigate(Screen.Login.route) {
                        popUpTo(MAIN_ROUTE) {
                            inclusive = true
                        }
                    }
                }

            }) {
                Image(
                    modifier = Modifier.size(MySettings.Sizes.iconSizes),
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = screen.description
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            scrolledContainerColor = MySettings.ColorThemeLight.primary,
            containerColor = MySettings.ColorThemeLight.primary,
            titleContentColor = MySettings.ColorThemeLight.icons,
            navigationIconContentColor = MySettings.ColorThemeLight.icons
        ),
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun MyBottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.Home,
        Screen.AddBet,
        Screen.History,
        Screen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(MySettings.NavigationBarSettings.heightDp),
        containerColor = MySettings.ColorThemeLight.primary,
        contentColor = contentColorFor(backgroundColor = MySettings.ColorThemeLight.primary)

    ) {
        screens.forEach { screen ->
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
    navController: NavHostController
) {
    NavigationBarItem(
        label = { Text(screen.name) },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(MAIN_ROUTE) {
                    inclusive = true
                }
            }
        },
        icon = { Icon(imageVector = screen.icon, contentDescription = screen.description) },
        colors = NavigationBarItemColors
            (
            selectedIndicatorColor = MySettings.ColorThemeLight.primary,
            unselectedIconColor = MySettings.ColorThemeLight.icons,
            disabledIconColor = MySettings.ColorThemeLight.icons,
            selectedIconColor = MySettings.ColorThemeLight.tertiary,
            disabledTextColor = MySettings.ColorThemeLight.icons,
            selectedTextColor = MySettings.ColorThemeLight.tertiary,
            unselectedTextColor = MySettings.ColorThemeLight.icons
        )
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewMainView() {
    MainView(MainActivity())
}