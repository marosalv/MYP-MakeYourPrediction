package com.marosalvsoftware.myp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.marosalvsoftware.myp.screens.MainView
import com.marosalvsoftware.myp.ui.theme.MYPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MYPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val mod : Modifier = Modifier
                    mod.padding(innerPadding)
                    mod.fillMaxHeight(0.15f)
                    Greeting(
                        name = "Android",
                        modifier = mod,
                        this
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context : Context) {
    MainView(modifier = modifier, context = context)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MYPTheme {
        Greeting("Android", Modifier, LocalContext.current)
    }
}