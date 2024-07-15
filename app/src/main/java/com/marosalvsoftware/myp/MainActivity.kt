package com.marosalvsoftware.myp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.marosalvsoftware.myp.screens.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MYPTheme {
                MainView(activity = this)
//          }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview(){
    MainView(activity = MainActivity())
}