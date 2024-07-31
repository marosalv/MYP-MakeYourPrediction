package com.marosalvsoftware.myp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.marosalvsoftware.myp.CardFiller
import com.marosalvsoftware.myp.MainActivity
import com.marosalvsoftware.myp.settings.MySettings
import com.marosalvsoftware.myp.data.online.getCoinCapResp
import com.marosalvsoftware.myp.saveCardFiller
import com.marosalvsoftware.myp.updatedCardFiller
import java.time.LocalDate
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AddBetScreen(
    navController: NavHostController,
    activity: MainActivity
) {

    val state = rememberLazyListState()
    val updatedList = updatedCardFiller(activity)
    Thread {
        val coinCapResp = getCoinCapResp()

        if (coinCapResp != null)
            for (card in updatedList)
                for (coin in coinCapResp.data)
                    if (card.ticker == coin.symbol) {
                        if (coin.priceUsd!!.toDouble() < 1)
                            if (coin.priceUsd!!.toDouble() < 0.0001)
                                card.actualPrice = String.format(Locale.ENGLISH,"%.16f",coin.priceUsd!!.toDouble())
                            else
                                card.actualPrice = String.format(Locale.ENGLISH,"%.12f",coin.priceUsd!!.toDouble())
                        else
                            card.actualPrice = String.format(Locale.ENGLISH,"%.4f", coin.priceUsd!!.toDouble())
                    }

    }.start()

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            MyTopBar(screen = Screen.AddBet, scrollBehaviour, activity.baseContext, navController)
        }) { paddingValues ->


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
            items(items = updatedList, itemContent = {
                CardBetCreator(it, activity)
            })
            item {
                Spacer(Modifier.size(MySettings.Paddings.large))
            }

        }
    }

}

@Composable
fun CardBetCreator(cardFiller: CardFiller, activity: MainActivity) {

    val painter: Painter = painterResource(id = cardFiller.iconID)
    val colorCard = MySettings.ColorThemeLight.cardBacground
    val popUpState = remember { mutableStateOf(false) }

    val lastVote = remember {
        mutableStateOf(cardFiller.voteDateList.last())
    }
    if (!isAlreadyVoted(LocalDate.parse(lastVote.value))) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MySettings.Paddings.medium),
            shape = RoundedCornerShape(MySettings.Paddings.large),
            elevation = CardDefaults.cardElevation(MySettings.Paddings.small),
            colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.cardBacground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MySettings.Paddings.small),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Image(
                        modifier = Modifier
                            .padding(MySettings.Paddings.small)
                            .size(MySettings.Sizes.iconSizes),
                        painter = painter,
                        contentDescription = cardFiller.actualPrice
                    )

                    Text(
                        text = cardFiller.name,
                        modifier = Modifier.padding(end = MySettings.Paddings.medium),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Right
                ) {
                    Text(
                        text = cardFiller.actualPrice,
                        modifier = Modifier.padding(end = MySettings.Paddings.medium),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )

                    IconButton(
                        modifier = Modifier
                            .size(MySettings.Sizes.iconSizes),
                        onClick = {
                            popUpState.value = !popUpState.value
                        }
                    )
                    {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            contentDescription = "Add New Bet",
                            imageVector = Icons.Outlined.Add,
                            tint = MySettings.ColorThemeLight.secondary
                        )
                    }

                }
            }

        }
    }
    if (popUpState.value) {
        Popup(
            properties = PopupProperties(focusable = true, dismissOnBackPress = true)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f),
                shape = RoundedCornerShape(MySettings.Paddings.large),
                colors = CardDefaults.cardColors(containerColor = colorCard),
                elevation = CardDefaults.cardElevation(MySettings.Paddings.large)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .clickable(onClick = { popUpState.value = !popUpState.value })
                            .padding(MySettings.Paddings.small)
                            .size(MySettings.Sizes.iconSizes),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MySettings.ColorThemeLight.icons
                    )
                    //Title
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        text = "Predict " + cardFiller.name,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //Body
                    Text(
                        textAlign = TextAlign.Justify,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        text = "Vote your market prediction" +
                                "\n -- Actual value: ${cardFiller.actualPrice}" +
                                "\n -- Till Date: ${fromTodayDate(15)}"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Card(
                            modifier = Modifier.clickable
                            {
                                val voteDate = LocalDate.now().toString()
                                popUpState.value = !popUpState.value
                                cardFiller.voteDateList.add(voteDate)
                                cardFiller.isUptrendList.add(false)

                                saveCardFiller(activity = activity, cardFiller = cardFiller)

                                lastVote.value = voteDate

                            },
                            colors = CardDefaults.cardColors(containerColor = colorCard),
                            elevation = CardDefaults.cardElevation(MySettings.Paddings.small)
                        )
                        {
                            Icon(
                                modifier = Modifier.size(MySettings.Sizes.iconSizes * 2),
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = null,
                                tint = MySettings.ColorThemeLight.downTrend
                            )
                        }
                        Card(
                            modifier = Modifier.clickable
                            {
                                val voteDate = LocalDate.now().toString()
                                popUpState.value = !popUpState.value
                                cardFiller.voteDateList.add(voteDate)
                                cardFiller.isUptrendList.add(true)

                                saveCardFiller(activity = activity, cardFiller = cardFiller)

                                lastVote.value = voteDate
                            },
                            colors = CardDefaults.cardColors(containerColor = colorCard),
                            elevation = CardDefaults.cardElevation(MySettings.Paddings.small)
                        )
                        {
                            Icon(
                                modifier = Modifier.size(MySettings.Sizes.iconSizes * 2),
                                imageVector = Icons.Filled.ArrowDropUp,
                                contentDescription = null,
                                tint = MySettings.ColorThemeLight.upTrend
                            )
                        }
                    }
                }
            }
        }
    }

}

fun fromTodayDate(i: Long): LocalDate {
    return LocalDate.now().plusDays(i)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun isAlreadyVoted(lastVote: LocalDate): Boolean {
    return LocalDate.now().minusDays(1).isBefore(lastVote)
}
