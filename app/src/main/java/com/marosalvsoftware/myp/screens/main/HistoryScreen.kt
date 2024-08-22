package com.marosalvsoftware.myp.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.marosalvsoftware.myp.CardFiller
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.screens.MyBottomBar
import com.marosalvsoftware.myp.screens.MyTopBar
import com.marosalvsoftware.myp.screens.Screen
import com.marosalvsoftware.myp.settings.MySettings
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
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection).fillMaxSize(),
        bottomBar = { MyBottomBar(navController = navController) },
        topBar = { MyTopBar(Screen.History, scrollBehaviour, activity.baseContext, navController) }
    ) {itt->
        itt.calculateBottomPadding()
        itt.calculateTopPadding()

        val state = rememberLazyListState()
        val updatedList = updatedCardFiller(activity = activity)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = MySettings.ColorThemeLight.background)
                .padding(itt),
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
        else -> {
            ExpandableCard(cardFiller = cardFiller)

        }
    }
}

@Composable
fun ExpandableCard(cardFiller: CardFiller) {
    val isExpanded = rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MySettings.Paddings.medium),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.cardBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(MySettings.Paddings.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Row(
                modifier = Modifier.align(alignment = Alignment.Top),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Image(
                    modifier = Modifier
                        .padding(MySettings.Paddings.small)
                        .size(MySettings.Sizes.iconSizes)
                        .align(alignment = Alignment.Top),
                    painter = painterResource(id = cardFiller.iconID),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .padding(MySettings.Paddings.medium),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = cardFiller.name, fontSize = MaterialTheme.typography.h6.fontSize)
                    if (isExpanded.value) {
                        for (i in 1..<cardFiller.voteDateList.size) {
                            Text(
                                text = cardFiller.voteDateList[i] + " --> " + cardFiller.isUptrendList[i],
                                fontSize = MaterialTheme.typography.body1.fontSize,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
            }

            Row(
                modifier = Modifier.align(alignment = Alignment.Top),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Right
            ) {
                /*TODO
                ** one day think to add share button
                */
                IconButton(modifier = Modifier
                    .size(MySettings.Sizes.iconSizes),
                    onClick = { isExpanded.value = !isExpanded.value }) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        imageVector =
                        if (isExpanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
        }
    }


}