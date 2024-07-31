package com.marosalvsoftware.myp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import com.marosalvsoftware.myp.settings.MySettings
import com.marosalvsoftware.myp.ui.theme.MYPTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MYPTheme {
                MySplashScreen()
            }
        }
    }


    @Composable
    fun MySplashScreen() {

        val alpha = remember { Animatable(0f) }

        LaunchedEffect(key1 = true) {
            alpha.animateTo(
                1f,
                animationSpec = tween(1500)
            )

            //Attendere 2 secondi prima di avviare l'activity principale
            delay(1000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = MySettings.ColorThemeLight.background),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(alpha = alpha.value),
                painter = painterResource(
                    id = R.drawable.logo_myp2
                ),
                contentDescription = "Logo"
            )
        }
    }
}