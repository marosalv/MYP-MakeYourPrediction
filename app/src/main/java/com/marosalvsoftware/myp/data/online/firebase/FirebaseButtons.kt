package com.marosalvsoftware.firebase_signin.online.firebase

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SignOutButton(onSignOut: () -> Unit) {
    Button(onClick = {
        FirebaseManager().signOut{onSignOut()}
    }) {
        Text(text = "Sign Out")
    }
}