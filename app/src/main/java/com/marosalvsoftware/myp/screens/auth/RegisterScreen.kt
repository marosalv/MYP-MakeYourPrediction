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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.credentials.PasswordCredential
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.firebase_signin.online.firebase.FirebaseManager
import com.marosalvsoftware.firebase_signin.online.google.GoogleSignInButton
import com.marosalvsoftware.myp.navgraph.AUTH_ROUTE
import com.marosalvsoftware.myp.navgraph.MAIN_ROUTE
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.settings.MySettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: CoroutineScope = FirebaseManager().viewModelScope) {

    val emailField = MutableStateFlow("")
    val passField = MutableStateFlow("")
    //TODO add graphics to register with Google API, Facebook API, Email password
    var visualPass = false

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

                TextField(
                    value = "Email",
                    onValueChange = { emailField.value = it })

                TextField(
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable {visualPass = !visualPass},
                            imageVector = if(visualPass) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null
                    )},
                    value = "Password",
                    visualTransformation = if(visualPass) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { passField.value = it })

                Button(
                    onClick = {
                        navController.navigate(MAIN_ROUTE) {
                            popUpTo(AUTH_ROUTE) {
                                inclusive = true
                            }
                        }
                    }) {
                    Text(text = "Register with email")
                }
                GoogleSignInButton {credential ->
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