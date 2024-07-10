package com.marosalvsoftware.myp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.marosalvsoftware.myp.MySettings
import com.marosalvsoftware.myp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBetScreen(navController: NavHostController, context : Context ) {

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            TopBarCreator(screen = Screen.AddBet, scrollBehaviour, context, navController)
        }) { paddingValues ->

        val state = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Blue,
                            Color.Green,
                            Color.White,
                            Color.Yellow
                        )
                    )
                )
                .padding(
                    start = MySettings.Paddings.medium,
                    end = MySettings.Paddings.medium,
                    bottom = MySettings.NavigationBarSettings.heightDp + MySettings.Paddings.small
                )
                .padding(paddingValues),
            state = state,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = CardFiller.GetAllCards().getList(), itemContent = {
                CardBetCreator(it, context)
            })

        }
    }
}

@Composable
private fun LazyItemScope.CardBetCreator(cardFiller: CardFiller, context : Context){
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(top = MySettings.Paddings.medium)
        .height(70.dp),
        shape = RoundedCornerShape(MySettings.Paddings.large),
        elevation = CardDefaults.elevatedCardElevation(MySettings.Paddings.small),
        colors = CardDefaults.cardColors(containerColor = MySettings.ColorThemeLight.primary),
        border = CardDefaults.outlinedCardBorder(),

        ){
        Row (modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
            ){
            Image(
                modifier = Modifier
                    .padding(
                        start = MySettings.Paddings.medium,
                        end = MySettings.Paddings.small
                    )
                    .size(MySettings.Sizes.iconSizes),
                painter = painterResource(id = cardFiller.iconID),
                contentDescription = cardFiller.actualPrice)

            Text(
                text = cardFiller.name,
                modifier = Modifier.padding(end = MySettings.Paddings.medium),
                fontSize = MaterialTheme.typography.headlineSmall.fontSize)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = MySettings.Paddings.medium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.Right){
                Text(
                text = cardFiller.actualPrice,
                modifier = Modifier.padding(end = MySettings.Paddings.medium),
                fontSize = MaterialTheme.typography.headlineSmall.fontSize)

                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add New Bet",
                    modifier = Modifier
                        .size(MySettings.Sizes.iconSizes)
                        .clickable {
                            /*TODO: Inserire la logica per aprire una pagina flottante per fare una scommessa*/
                            context.toast("Non ancora implementato: \n Aggiungi bet per ${cardFiller.name}")
                        })

            }
        }
    }
}

fun Context.toast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCreator(screen : Screen, scrollBehavior: TopAppBarScrollBehavior, context: Context, navController: NavHostController)
{
    MediumTopAppBar(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        title = { Text(
            modifier = Modifier.padding(start = MySettings.Paddings.small),
            text = screen.name,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
                },
        navigationIcon = { IconButton(onClick = {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
        }) {
            Image(
                modifier = Modifier.size(MySettings.Sizes.iconSizes),
                imageVector = Screen.Home.icon,
                contentDescription = screen.description)}
        },
        actions = {
            IconButton(onClick = {
            /*TODO*/
            context.toast("Non ancora implementato, aprirà la tendina per ulteriori impostazioni")
            }) {
                Image(
                    modifier = Modifier.size(MySettings.Sizes.iconSizes),
                    imageVector = Icons.Filled.Menu,
                    contentDescription = screen.description)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            scrolledContainerColor = MySettings.ColorThemeLight.primary,
            containerColor = MySettings.ColorThemeLight.primary,
            titleContentColor = MySettings.ColorThemeLight.icons,
            navigationIconContentColor = MySettings.ColorThemeLight.icons),
        scrollBehavior = scrollBehavior
    )
}


sealed class CardFiller(
    val color: Color,
    val name: String,
    val iconID: Int,
    val actualPrice: String,
    val ticker: String
){
    data object Bitcoin: CardFiller(
        color = Color.Yellow,
        name = "Bitcoin",
        iconID =  R.drawable.bitcoin,
        actualPrice = "18000",
        ticker = CryptoListTicker.Bitcoin.ticker
    )
    data object Ethereum: CardFiller(
        color = Color.Cyan,
        name = "Ethereum",
        iconID = R.drawable.ethereum,
        actualPrice = "2000",
        ticker = CryptoListTicker.Ethereum.ticker
    )
    data object Solana: CardFiller(
        color = Color.Magenta,
        name = "Solana",
        iconID = R.drawable.solana,
        actualPrice = "200",
        ticker = CryptoListTicker.Solana.ticker
    )
    data object Binance: CardFiller(
        color = Color.Green,
        name = "Binance",
        iconID = R.drawable.binance_coin,
        actualPrice = "156",
        ticker = CryptoListTicker.Binance.ticker
    )
    data object Polkadot: CardFiller(
        color = Color.Blue,
        name = "Polkadot",
        iconID = R.drawable.polkadot,
        actualPrice = "0.26",
        ticker = CryptoListTicker.Polkadot.ticker
    )
    data object Tether: CardFiller(
        color = Color.Red,
        name = "Tether",
        iconID = R.drawable.tether,
        actualPrice = "1",
        ticker = CryptoListTicker.Tether.ticker
    )
    data object Uniswap: CardFiller(
        color = Color.Gray,
        name = "Uniswap",
        iconID = R.drawable.uniswap,
        actualPrice = "0.35",
        ticker = CryptoListTicker.Uniswap.ticker
    )
    data object Maker: CardFiller(
        color = Color.Black,
        name = "Maker",
        iconID = R.drawable.maker,
        actualPrice = "0.12",
        ticker = CryptoListTicker.Maker.ticker
    )
    data object Chainlink: CardFiller(
        color = Color.DarkGray,
        name = "Chainlink",
        iconID = R.drawable.chainlink,
        actualPrice = "12",
        ticker = CryptoListTicker.Chainlink.ticker
    )
    data object MakerDAO: CardFiller(
        color = Color.Magenta,
        name = "MakerDAO",
        iconID = R.drawable.dao_maker,
        actualPrice = "0.32",
        ticker = CryptoListTicker.MakerDAO.ticker
    )
    class GetAllCards
    {
        fun getList() : List<CardFiller>
        {
            return listOf(
                Bitcoin,
                Ethereum,
                Solana,
                Binance,
                Polkadot,
                Tether,
                Uniswap,
                Maker,
                Chainlink,
                MakerDAO
            )

        }
    }
}

enum class CryptoListTicker(val ticker:String){
    Bitcoin ("BTC"),
    Ethereum ("ETH"),
    Solana ("SOL"),
    Binance ("BNB"),
    Polkadot ("DOT"),
    Tether ("USDT"),
    Uniswap ("UNI"),
    Maker ("MKR"),
    Chainlink ("LINK"),
    MakerDAO ("MKRDAO")
}




@Composable
@Preview (showBackground = true)
fun PreviewAddBetScreen(){
    AddBetScreen(rememberNavController(),LocalContext.current)
}