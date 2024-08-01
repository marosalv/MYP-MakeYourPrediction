package com.marosalvsoftware.myp.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.data.online.AuthenticationUser
import com.marosalvsoftware.myp.navgraph.AUTH_ROUTE
import com.marosalvsoftware.myp.navgraph.MAIN_ROUTE
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.settings.MySettings

@Composable
fun RegisterScreen(navController: NavHostController) {
    //TODO add graphics to register with Google API, Facebook API, Email password

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = MySettings.ColorThemeLight.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxSize(0.95f),
            elevation = CardDefaults.cardElevation(MySettings.Paddings.small)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = MySettings.ColorThemeLight.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = Screen.Register.description,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                )
                Spacer(modifier = Modifier.size(MySettings.Sizes.headerBand))
                Button(
                    onClick = {
                        AuthenticationUser(successLogin = true)
                        navController.navigate(MAIN_ROUTE) {
                            popUpTo(AUTH_ROUTE) {
                                inclusive = true
                            }
                        }
                    }) {
                    Text(text = "Navigate to Main Graph\nAuth completed test")
                }
                Spacer(modifier = Modifier.size(MySettings.Paddings.small))
                Row {
                    Text(
                        text = "Login",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.Login.route) {
                                    popUpTo(AUTH_ROUTE) {
                                        inclusive = true
                                    }
                                }
                            }
                            .padding(MySettings.Paddings.small),
                    )
                    Text(
                        text = "Forgot",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.Forgot.route) {
                                    popUpTo(AUTH_ROUTE) {
                                        inclusive = true
                                    }
                                }
                            }
                            .padding(MySettings.Paddings.small)
                    )
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewRegisterScreen() {
    RegisterScreen(navController = rememberNavController())
}