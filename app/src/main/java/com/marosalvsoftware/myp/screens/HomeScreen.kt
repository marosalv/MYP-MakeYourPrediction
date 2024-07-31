package com.marosalvsoftware.myp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.CardFiller
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.settings.MySettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, activity: MainActivity) {

    val scrollState = rememberLazyGridState()
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val cardFiller = CardFiller.GetAllCards().getList()


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            MyTopBar(Screen.Home, scrollBehaviour, activity.baseContext, navController)
        }) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .background(brush = MySettings.ColorThemeLight.background)
                .padding(
                    bottom = MySettings.NavigationBarSettings.heightDp,
                    start = MySettings.Paddings.medium
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            state = scrollState
        ) {
            items(cardFiller) {
                DetailRowCreator(it)
            }
            items(2) {
                Spacer(Modifier.size(MySettings.Paddings.large))
            }
        }
    }
}

@Composable
fun LazyGridItemScope.DetailRowCreator(cardFiller: CardFiller) {

    val painter: Painter = painterResource(id = cardFiller.iconID)
    val colorCard = MySettings.ColorThemeLight.cardBacground
    Card(
        modifier = Modifier
            .padding(top = MySettings.Paddings.medium, end = MySettings.Paddings.medium)
            .fillMaxWidth(0.9f)
            .size(MySettings.Sizes.cardSize_big),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = colorCard)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Text(
                text = cardFiller.name,
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MySettings.Paddings.small),
                fontWeight = FontWeight.Bold
            )

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
                    painter = painter,
                    contentDescription = "Logo"
                )
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val mod = Modifier.width(70.dp).height(30.dp)
                val baseColor = CardDefaults.cardColors(containerColor = Color.White)
                Card(
                    colors = baseColor,
                    modifier = mod,
                    shape = RoundedCornerShape(MySettings.Paddings.large)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropDown,
                            contentDescription = "downTrend",
                            tint = MySettings.ColorThemeLight.downTrend
                        )
                        Text(
                            text = " 99.7% ",
                            color = MySettings.ColorThemeLight.downTrend,
                            fontSize = MaterialTheme.typography.subtitle1.fontSize
                        )
                    }
                }

//                Spacer(Modifier.size(MySettings.Paddings.small))
                Card(
                    colors = baseColor,
                    modifier = mod,
                    shape = RoundedCornerShape(MySettings.Paddings.large)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropUp,
                            contentDescription = "upTrend",
                            tint = MySettings.ColorThemeLight.upTrend
                        )
                        Text(
                            text = " 0.3% ",
                            color = MySettings.ColorThemeLight.upTrend,
                            fontSize = MaterialTheme.typography.subtitle1.fontSize
                        )
                    }
                }
            }
        }
    }
}
