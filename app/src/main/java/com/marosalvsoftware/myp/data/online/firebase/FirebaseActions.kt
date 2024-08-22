package com.marosalvsoftware.firebase_signin.online.firebase

import android.content.Context
import android.util.Log
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

interface FirebaseActions {
    fun initializeFirebase(context: Context){ FirebaseApp.initializeApp(context)}
    suspend fun signInWithGoogle(credential: Credential,onCompleteLogin: () -> Unit)
    fun signOut(onSignOut: () -> Unit) {

            Firebase.auth.signOut()
            onSignOut()

    }
    suspend fun signInAnonymously(onCompleteLogin: () -> Unit)
    {
        Firebase.auth.signInAnonymously().await()
        if(isUserSignedIn())        onCompleteLogin()
    }

    suspend fun signInWithCredential(credential: AuthCredential,onCompleteLogin: () -> Unit)
    {
        Firebase.auth.signInWithCredential(credential).await()
        if(isUserSignedIn())        onCompleteLogin()
    }

    suspend fun signInWithEmailAndPassword(email: String, password: String,onCompleteLogin: () -> Unit)
    {
        Firebase.auth.signInWithEmailAndPassword(email, password).await()
        if(isUserSignedIn())        onCompleteLogin()
    }

    suspend fun resetPassword(email: String, onCompleteReset: () -> Unit)
    {
        Firebase.auth.sendPasswordResetEmail(email).await()
        onCompleteReset()
    }

    fun getCurrentUser() = Firebase.auth.currentUser

    fun isUserSignedIn() = Firebase.auth.currentUser != null

    fun isUserAnonymous() = Firebase.auth.currentUser?.isAnonymous ?: false

    fun getUserId() = Firebase.auth.currentUser?.uid

    fun getUserName() = Firebase.auth.currentUser?.displayName
}

class FirebaseManager : FirebaseActions, ViewModel() {
    override suspend fun signInWithGoogle(credential: Credential, onCompleteLogin: () -> Unit) {
        viewModelScope.launch {
            if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                signInWithCredential(getCredentialFromGoogleToken(credential),onCompleteLogin)

            } else {
                Log.e("ERROR", "invalid credential type")
            }
        }
    }

    suspend fun onCompletedGoogleLogin(credential: Credential, onCompletedBlock: () -> Unit) {
        signInWithGoogle(credential) {
            onCompletedBlock()
        }
    }

}

private fun getCredentialFromGoogleToken(credential: Credential): AuthCredential{
    val googleIdTypeCredential = GoogleIdTokenCredential.createFrom(credential.data)
    return GoogleAuthProvider.getCredential(googleIdTypeCredential.idToken,null)
}