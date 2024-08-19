package com.marosalvsoftware.firebase_signin.online.google

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.marosalvsoftware.firebase_signin.online.firebase.SignOutButton
import com.marosalvsoftware.myp.R
import com.marosalvsoftware.myp.settings.GOOGLE_CLIENT_ID
import kotlinx.coroutines.launch


@Composable
fun GoogleSignInButton(
    title: String = "Sign in with Google",
    onCompletedAction: (Credential) -> Unit){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val credentialManager = CredentialManager.create(context)

    Button(
        onClick = {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(GOOGLE_CLIENT_ID)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            coroutineScope.launch {
                try {
                    val result = credentialManager.getCredential(
                        request = request,
                        context = context
                    )
                    onCompletedAction(result.credential)
                }catch (e: Exception){
                    Log.e("GoogleSignInButton : ERROR", "Google sign-in failed" + e.message)
                }
            }
    }) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(
                id = R.drawable.googlecom)
            ,contentDescription = null)

        Spacer(modifier = Modifier.size(8.dp))

        Text(text = title)

    }

}

@Composable
fun GoogleSignOutButton(onSignOut: () ->Unit ) {
    SignOutButton {
        onSignOut()
    }
}