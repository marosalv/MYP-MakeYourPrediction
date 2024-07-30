package com.marosalvsoftware.myp.screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marosalvsoftware.myp.CardFiller
import com.marosalvsoftware.myp.CryptoListTicker
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.MySettings
import com.marosalvsoftware.myp.data.local.readFromDatabase
import com.marosalvsoftware.myp.updatedCardFiller

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavHostController,
    activity: MainActivity
) {
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            MyTopBar(Screen.History, scrollBehaviour, activity.baseContext, navController)
        }) { paddingValues ->

        val state = rememberLazyListState()
        val updatedList = updatedCardFiller(activity = activity)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = MySettings.ColorThemeLight.background)
                .padding(paddingValues)
                .padding(
                    start = MySettings.Paddings.medium,
                    end = MySettings.Paddings.medium,
                    bottom = MySettings.NavigationBarSettings.heightDp
                ),
            state = state,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = updatedList) {
                CreateCardHistory(it)
            }
            item {
                Spacer(Modifier.height(MySettings.Paddings.large))
            }
        }
    }
}

@Composable
fun CreateCardHistory(cardFiller: CardFiller) {

    when (cardFiller.voteDateList.size) {
        0 -> return
        1 -> return
        2 -> NormalCard(title = cardFiller.name, cardFiller = cardFiller)

        else -> {
            ExpandableCard(title = cardFiller.name, cardFiller = cardFiller)

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHistoryScreen() {
    HistoryScreen(
        navController = NavHostController(MainActivity()),
        activity = MainActivity()
    )
}

@Composable
fun NormalCard(title: String, cardFiller: CardFiller){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MySettings.Paddings.medium),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.cardBacground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MySettings.Paddings.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cardFiller.name + " " + cardFiller.voteDateList.last() + " --> " + cardFiller.isUptrendList.last(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ExpandableCard(title: String, cardFiller: CardFiller) {
    val expanded = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.height(if(expanded.value) MySettings.Sizes.cardSize_big else 50.dp)
            .padding(top = MySettings.Paddings.medium),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.cardBacground)
    ) {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
            Text(
                text = title,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MySettings.Paddings.medium),
                fontSize = MaterialTheme.typography.h6.fontSize
            )
            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(imageVector =
                if(expanded.value)Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                    contentDescription = null)
            }
        }
        if (expanded.value) {
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                for (i in 1..<cardFiller.voteDateList.size) {
                    Text(
                        text = cardFiller.voteDateList[i] + " --> " + cardFiller.isUptrendList[i],
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}