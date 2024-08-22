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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.marosalvsoftware.firebase_signin.online.firebase.FirebaseManager
import com.marosalvsoftware.firebase_signin.online.google.GoogleSignInButton
import com.marosalvsoftware.myp.navgraph.AUTH_ROUTE
import com.marosalvsoftware.myp.navgraph.MAIN_ROUTE
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.settings.MySettings
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    //TODO add graphics to log in with Google API, Facebook API, Email

    val emailField = remember { mutableStateOf("") }
    val passField = remember { mutableStateOf("") }
    val visualPass = remember { mutableStateOf(false) }
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
                    text = Screen.Login.description,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                )
                Spacer(modifier = Modifier.size(MySettings.Sizes.headerBand))

                TextField(
                    singleLine = true,
                    label = { Text("Email") },
                    shape = MaterialTheme.shapes.extraLarge,
                    value = emailField.value,
                    onValueChange = { emailField.value = it })

                Spacer(modifier = Modifier.size(MySettings.Paddings.small))

                TextField(
                    singleLine = true,
                    label = { Text("Password") },
                    shape = MaterialTheme.shapes.extraLarge,
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable { visualPass.value = !visualPass.value },
                            imageVector = if (visualPass.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null
                        )
                    },
                    value = passField.value,
                    visualTransformation = if (visualPass.value) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { passField.value = it })

                Spacer(modifier = Modifier.size(MySettings.Paddings.small))

                Button(
                    onClick = {
                        FirebaseManager().viewModelScope.launch{
                            FirebaseManager().signInWithEmailAndPassword(emailField.value, passField.value){
                                navController.navigate(MAIN_ROUTE) {
                                    popUpTo(AUTH_ROUTE) {
                                        inclusive = true
                                    }
                                }
                            }
                        }

                    }) {
                    Text(text = "Login with Email")
                }


                GoogleSignInButton { credential ->
                    FirebaseManager().viewModelScope.launch {
                        FirebaseManager().onCompletedGoogleLogin(credential) {
                            navController.navigate(MAIN_ROUTE) {
                                popUpTo(AUTH_ROUTE) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.size(MySettings.Paddings.small))

                Row {
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
                            .padding(MySettings.Paddings.small))
                }
            }
        }
    }
}
