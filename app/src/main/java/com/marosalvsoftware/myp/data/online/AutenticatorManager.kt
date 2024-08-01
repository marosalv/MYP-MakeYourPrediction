package com.marosalvsoftware.myp.data.online

import androidx.compose.runtime.mutableStateOf


private val IsUserAuth = mutableStateOf(false)
fun isUsedAuthenticated() : Boolean{
    return IsUserAuth.value
}

fun AuthenticationUser(successLogin : Boolean){
    IsUserAuth.value = successLogin
}
