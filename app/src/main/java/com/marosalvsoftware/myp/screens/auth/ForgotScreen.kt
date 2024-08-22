package com.marosalvsoftware.myp.screens.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.firebase_signin.online.firebase.FirebaseManager
import com.marosalvsoftware.myp.navgraph.AUTH_ROUTE
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.settings.MySettings
import kotlinx.coroutines.launch

@Composable
fun ForgotScreen(navController: NavHostController) {
    //TODO insert all graphics inside to recover the password

    val emailField = remember{mutableStateOf("")}
    val context = LocalContext.current

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
                    text = Screen.Forgot.description,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                )
                Spacer(modifier = Modifier.size(MySettings.Sizes.headerBand))

                TextField(
                    singleLine = true,
                    label = { Text("Email") },
                    shape = MaterialTheme.shapes.extraLarge,
                    value = emailField.value,
                    onValueChange = { emailField.value = it })

                Button(
                    onClick = {
                        FirebaseManager().viewModelScope.launch {
                            FirebaseManager().resetPassword(emailField.value,
                                onCompleteReset = {
                                    navController.navigate(Screen.Login.route){
                                        popUpTo(AUTH_ROUTE){
                                            inclusive = true
                                        } } })
                        }.start()

                        Toast.makeText(context, "Sended email to recover the password", Toast.LENGTH_LONG).show()

                    }) {
                    Text(text = "Recover password")
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
                            .padding(MySettings.Paddings.small)
                    )
                    Text(
                        text = "Register",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.Register.route) {
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
fun PreviewForgotScreen() {
    ForgotScreen(navController = rememberNavController())
}