package com.marosalvsoftware.myp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.MySettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, context: Context) {

    val scrollState = rememberLazyGridState()
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            TopBarCreator(Screen.Home, scrollBehaviour, context, navController)
        }) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .padding(
                    bottom = MySettings.NavigationBarSettings.heightDp,
                    start = MySettings.Paddings.medium
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            state = scrollState
        ) {
            items(CryptoListTicker.entries) {
                DetailRowCreator(it, CardFiller.Bitcoin)
            }
        }
    }
}

@Composable
fun LazyGridItemScope.DetailRowCreator(ticker: CryptoListTicker, cardFiller: CardFiller) {

    Card(
        modifier = Modifier
            .padding(top = MySettings.Paddings.medium, end = MySettings.Paddings.medium)
            .fillMaxWidth(0.9f)
            .size(140.dp),
        shape = RoundedCornerShape(MySettings.Paddings.large)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MySettings.Paddings.small)
                    .size(MySettings.Sizes.iconSizes * 1.5f),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    alignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = cardFiller.iconID),
                    contentDescription = "Logo"
                )
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    shape = RoundedCornerShape(MySettings.Paddings.large),
                    colors = CardDefaults.cardColors(containerColor = Color.Red),
                    elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small / 2)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(MySettings.Paddings.small),
                        text = " 30% ",
                        color = MySettings.ColorThemeLight.text,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
                Card(
                    shape = RoundedCornerShape(MySettings.Paddings.large),
                    colors = CardDefaults.cardColors(containerColor = Color.Green),
                    elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small / 2)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(MySettings.Paddings.small),
                        text = " 70% ",
                        color = MySettings.ColorThemeLight.text,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController(), LocalContext.current)
}