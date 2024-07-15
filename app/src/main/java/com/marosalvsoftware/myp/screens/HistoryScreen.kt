package com.marosalvsoftware.myp.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.marosalvsoftware.myp.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavHostController,
    activity: MainActivity,
    paddings: PaddingValues){

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    Scaffold(
        modifier = Modifier
            .padding(paddings)
            .nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            MyTopBar(Screen.History, scrollBehaviour, activity.baseContext, navController)
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material.Text(
                text = "History Screen",
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h3.fontSize
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHistoryScreen() {
    HistoryScreen(
        navController = NavHostController(MainActivity()),
        activity = MainActivity(),
        paddings = PaddingValues()
    )
}