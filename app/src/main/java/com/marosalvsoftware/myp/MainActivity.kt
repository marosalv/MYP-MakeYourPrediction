package com.marosalvsoftware.myp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.marosalvsoftware.myp.screens.MainView

open class MainActivity : ComponentActivity() {
//    internal var authListener: FirebaseAuth.AuthStateListener? =
//        FirebaseAuth.AuthStateListener { firebaseAuth ->
//            val user = firebaseAuth.currentUser
//            if (user == null) {
//                startActivity(Intent(this, SplashScreen::class.java))
//                finish()
//            } else {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView(activity = this)
        }


    }

}
