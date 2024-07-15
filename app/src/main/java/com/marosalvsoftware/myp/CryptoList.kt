package com.marosalvsoftware.myp

import android.content.Context
import androidx.compose.ui.graphics.Color
import java.time.LocalDate


sealed class CardFiller(
    val color: Color,
    val name: String,
    val iconID: Int,
    val actualPrice: String,
    val ticker: String,
    var lastVote: LocalDate = LocalDate.MIN
){
    data object Bitcoin: CardFiller(
        color = Color.Yellow,
        name = "Bitcoin",
        iconID =  R.drawable.bitcoin,
        actualPrice = "18000",
        ticker = CryptoListTicker.Bitcoin.ticker,
        lastVote = LocalDate.MIN
    )
    data object Ethereum: CardFiller(
        color = Color.Cyan,
        name = "Ethereum",
        iconID = R.drawable.ethereum,
        actualPrice = "2000",
        ticker = CryptoListTicker.Ethereum.ticker,
        lastVote = LocalDate.MIN
    )
    data object Solana: CardFiller(
        color = Color.Magenta,
        name = "Solana",
        iconID = R.drawable.solana,
        actualPrice = "200",
        ticker = CryptoListTicker.Solana.ticker,
        lastVote = LocalDate.MIN
    )
    data object Binance: CardFiller(
        color = Color.Green,
        name = "Binance",
        iconID = R.drawable.binance_coin,
        actualPrice = "156",
        ticker = CryptoListTicker.Binance.ticker,
        lastVote = LocalDate.MIN
    )
    data object Polkadot: CardFiller(
        color = Color.Blue,
        name = "Polkadot",
        iconID = R.drawable.polkadot,
        actualPrice = "0.26",
        ticker = CryptoListTicker.Polkadot.ticker,
        lastVote = LocalDate.MIN
    )
    data object Uniswap: CardFiller(
        color = Color.Gray,
        name = "Uniswap",
        iconID = R.drawable.uniswap,
        actualPrice = "0.35",
        ticker = CryptoListTicker.Uniswap.ticker,
        lastVote = LocalDate.MIN
    )
    data object Maker: CardFiller(
        color = Color.Black,
        name = "Maker",
        iconID = R.drawable.maker,
        actualPrice = "0.12",
        ticker = CryptoListTicker.Maker.ticker,
        lastVote = LocalDate.MIN
    )
    data object Chainlink: CardFiller(
        color = Color.DarkGray,
        name = "Chainlink",
        iconID = R.drawable.chainlink,
        actualPrice = "12",
        ticker = CryptoListTicker.Chainlink.ticker,
        lastVote = LocalDate.MIN
    )
    data object MakerDAO: CardFiller(
        color = Color.Magenta,
        name = "MakerDAO",
        iconID = R.drawable.dao_maker,
        actualPrice = "0.32",
        ticker = CryptoListTicker.MakerDAO.ticker,
        lastVote = LocalDate.MIN
    )
    data object Litecoin: CardFiller(
        color = Color.Yellow,
        name = "Litecoin",
        iconID =  R.drawable.litecoin,
        actualPrice = "18000",
        ticker = CryptoListTicker.Litecoin.ticker,
        lastVote = LocalDate.MIN
    )
    data object Ripple: CardFiller(
        color = Color.Cyan,
        name = "Ripple",
        iconID = R.drawable.xrp,
        actualPrice = "2000",
        ticker = CryptoListTicker.Ripple.ticker,
        lastVote = LocalDate.MIN
    )
    data object Algorand: CardFiller(
        color = Color.Magenta,
        name = "Algorand",
        iconID = R.drawable.algorand,
        actualPrice = "200",
        ticker = CryptoListTicker.Algorand.ticker,
        lastVote = LocalDate.MIN
    )

    data object Avalanche: CardFiller(
        color = Color.Green,
        name = "Avalanche",
        iconID = R.drawable.avalanche,
        actualPrice = "156",
        ticker = CryptoListTicker.Avalanche.ticker,
        lastVote = LocalDate.MIN
    )
    data object Tron: CardFiller(
        color = Color.Blue,
        name = "Tron",
        iconID = R.drawable.tron,
        actualPrice = "0.26",
        ticker = CryptoListTicker.Tron.ticker,
        lastVote = LocalDate.MIN
    )
    data object Dogecoin: CardFiller(
        color = Color.Gray,
        name = "Dogecoin",
        iconID = R.drawable.dogecoin,
        actualPrice = "0.35",
        ticker = CryptoListTicker.Dogecoin.ticker,
        lastVote = LocalDate.MIN
    )
    data object Cardano: CardFiller(
        color = Color.Black,
        name = "Cardano",
        iconID = R.drawable.cardano,
        actualPrice = "0.12",
        ticker = CryptoListTicker.Cardano.ticker,
        lastVote = LocalDate.MIN
    )
    data object Near: CardFiller(
        color = Color.DarkGray,
        name = "Near",
        iconID = R.drawable.near_protocol,
        actualPrice = "12",
        ticker = CryptoListTicker.Near.ticker,
        lastVote = LocalDate.MIN
    )
    data object Cosmos: CardFiller(
        color = Color.Magenta,
        name = "Cosmos",
        iconID = R.drawable.cosmos,
        actualPrice = "0.32",
        ticker = CryptoListTicker.Cosmos.ticker,
        lastVote = LocalDate.MIN
    )
    data object ShibaInu: CardFiller(
        color = Color.Yellow,
        name = "Shiba Inu",
        iconID =  R.drawable.shiba,
        actualPrice = "18000",
        ticker = CryptoListTicker.ShibaInu.ticker,
        lastVote = LocalDate.MIN
    )
    data object Arbitrum: CardFiller(
        color = Color.Cyan,
        name = "Arbitrum",
        iconID = R.drawable.arbitrum,
        actualPrice = "2000",
        ticker = CryptoListTicker.Arbitrum.ticker,
        lastVote = LocalDate.MIN
    )
    data object Fantom: CardFiller(
        color = Color.Magenta,
        name = "Fantom",
        iconID = R.drawable.fantom,
        actualPrice = "200",
        ticker = CryptoListTicker.Fantom.ticker,
        lastVote = LocalDate.MIN
    )
    data object Optimism: CardFiller(
        color = Color.Green,
        name = "Optimism",
        iconID = R.drawable.optimism_ethereum,
        actualPrice = "156",
        ticker = CryptoListTicker.Optimism.ticker,
        lastVote = LocalDate.MIN
    )
    data object Polygon: CardFiller(
        color = Color.Blue,
        name = "Polygon",
        iconID = R.drawable.polygon_ecosystem_token,
        actualPrice = "0.26",
        ticker = CryptoListTicker.Polygon.ticker,
        lastVote = LocalDate.MIN
    )
    data object Aave: CardFiller(
        color = Color.Gray,
        name = "Aave",
        iconID = R.drawable.aave,
        actualPrice = "0.35",
        ticker = CryptoListTicker.Aave.ticker,
        lastVote = LocalDate.MIN
    )
    data object EthereumClassic: CardFiller(
        color = Color.Black,
        name = "Ethereum Classic",
        iconID = R.drawable.ethereum_classic,
        actualPrice = "0.12",
        ticker = CryptoListTicker.EthereumClassic.ticker,
        lastVote = LocalDate.MIN
    )
    data object Filecoin: CardFiller(
        color = Color.DarkGray,
        name = "Filecoin",
        iconID = R.drawable.filecoin,
        actualPrice = "12",
        ticker = CryptoListTicker.Filecoin.ticker,
        lastVote = LocalDate.MIN
    )
    data object EOS: CardFiller(
        color = Color.Magenta,
        name = "EOS",
        iconID = R.drawable.eos,
        actualPrice = "0.32",
        ticker = CryptoListTicker.EOS.ticker,
        lastVote = LocalDate.MIN
    )
    data object Monero: CardFiller(
        color = Color.Yellow,
        name = "Monero",
        iconID =  R.drawable.monero,
        actualPrice = "18000",
        ticker = CryptoListTicker.Monero.ticker,
        lastVote = LocalDate.MIN
    )
    data object Stellar : CardFiller(
        color = Color.Cyan,
        name = "Stellar",
        iconID = R.drawable.stellar,
        actualPrice = "2000",
        ticker = CryptoListTicker.Stellar.ticker,
        lastVote = LocalDate.MIN
    )
    data object Curve : CardFiller(
        color = Color.Magenta,
        name = "Curve",
        iconID = R.drawable.curve_dao_token,
        actualPrice = "200",
        ticker = CryptoListTicker.Curve.ticker,
        lastVote = LocalDate.MIN
    )
    data object Zcash : CardFiller(
        color = Color.Green,
        name = "Zcash",
        iconID = R.drawable.zcash,
        actualPrice = "156",
        ticker = CryptoListTicker.Zcash.ticker,
        lastVote = LocalDate.MIN
    )
    data object InternetComputer : CardFiller(
        color = Color.Blue,
        name = "Internet Computer",
        iconID = R.drawable.internet_computer,
        actualPrice = "0.26",
        ticker = CryptoListTicker.InternetComputer.ticker,
        lastVote = LocalDate.MIN
    )
    data object TheGraph : CardFiller(
        color = Color.Gray,
        name = "The Graph",
        iconID = R.drawable.the_graph,
        actualPrice = "0.35",
        ticker = CryptoListTicker.TheGraph.ticker,
        lastVote = LocalDate.MIN
    )
    data object TheSandbox : CardFiller(
        color = Color.Black,
        name = "The Sandbox",
        iconID = R.drawable.the_sandbox,
        actualPrice = "0.12",
        ticker = CryptoListTicker.TheSandbox.ticker,
        lastVote = LocalDate.MIN
    )
    data object Chiliz : CardFiller(
        color = Color.DarkGray,
        name = "Chillz",
        iconID = R.drawable.chiliz,
        actualPrice = "12",
        ticker = CryptoListTicker.Chiliz.ticker,
        lastVote = LocalDate.MIN
    )
    data object Cronos: CardFiller(
        color = Color.Magenta,
        name = "Cronos",
        iconID = R.drawable.bonded_cronos,
        actualPrice = "0.32",
        ticker = CryptoListTicker.Cronos.ticker,
        lastVote = LocalDate.MIN
    )
    data object Decentraland: CardFiller(
        color = Color.Yellow,
        name = "Decentraland",
        iconID =  R.drawable.decentraland,
        actualPrice = "18000",
        ticker = CryptoListTicker.Decentraland.ticker,
        lastVote = LocalDate.MIN
    )
    data object NotCoin: CardFiller(
        color = Color.Cyan,
        name = "NotCoin",
        iconID = R.drawable.notcoin,
        actualPrice = "2000",
        ticker = CryptoListTicker.NotCoin.ticker,
        lastVote = LocalDate.MIN
    )


    class GetAllCards
    {
        fun getList() : List<CardFiller>
        {
            return listOf(
                Bitcoin,
                Ethereum,
                Binance,
                Solana,
                Polkadot,
                Uniswap,
                Maker,
                MakerDAO,
                Chainlink,
                Tron,
                Dogecoin,
                Cardano,
                Near,
                Cosmos,
                Avalanche,
                ShibaInu,
                Arbitrum,
                Fantom,
                Optimism,
                Polygon,
                Aave,
                EthereumClassic,
                Filecoin,
                EOS,
                Monero,
                Stellar,
                Curve,
                Zcash,
                InternetComputer,
                TheGraph,
                TheSandbox,
                Chiliz,
                NotCoin,
                Cronos,
                Decentraland,
                Algorand,
                Litecoin,
                Ripple
            )

        }
    }
}

enum class CryptoListTicker(val ticker:String){
    Bitcoin ("BTC"),
    Ethereum ("ETH"),
    Litecoin("LTC"),
    Binance ("BNB"),
    Solana ("SOL"),
    Ripple ("XRP"),
    Polkadot ("DOT"),
    Tron("TRX"),
    Dogecoin ("DOGE"),
    Avalanche("AVAX"),
    Uniswap ("UNI"),
    Maker ("MKR"),
    MakerDAO ("MKRDAO"),
    Chainlink ("LINK"),
    ShibaInu ("SHIB"),
    Cardano ("ADA"),
    Near("NEAR"),
    Cosmos ("ATOM"),
    Arbitrum ("ARBm"),
    Fantom ("FTM"),
    Optimism ("OP"),
    Polygon ("MATIC"),
    Aave ("AAVE"),
    EthereumClassic ("ETC"),
    Filecoin ("FIL"),
    EOS ("EOS"),
    Monero("XRM"),
    Stellar ("XLM"),
    Curve ("CRV"),
    Zcash ("ZEC"),
    InternetComputer ("ICP"),
    TheGraph ("GRT"),
    TheSandbox ("SAND"),
    Chiliz ("CHZ"),
    NotCoin("NOT"),
    Cronos ("CRO"),
    Decentraland ("MANA"),
    Algorand ("ALGO")
}


fun UpdateDatesCardFiller(activity: MainActivity): List<CardFiller> {
    //TODO fare arrivare i prezzi dal server Cionbase o Coinmarketcap per aggiornare il prezzo giornaliero
    //TODO Aggiornare anche l'ultima votazione fatta dall'utente tramite Firebase oppure una variabile salvata localmente

    var cardFillerList = CardFiller.GetAllCards().getList()

    val sharedPref =
        activity.getSharedPreferences(
            MySettings.DatabasePlaces.criptos,
            Context.MODE_PRIVATE)

    for (cardFiller in cardFillerList){
        var lastVote =
        sharedPref.getString(cardFiller.ticker, cardFiller.lastVote.toString())
        if(lastVote != null){
            cardFiller.lastVote = LocalDate.parse(lastVote)
        }
        else{
            cardFiller.lastVote = LocalDate.MIN
        }
    }
    return cardFillerList
}

fun SetDateCardFiller(activity: MainActivity, cardFiller: CardFiller){
    val editor =
        activity.getSharedPreferences(
            MySettings.DatabasePlaces.criptos,
            Context.MODE_PRIVATE).edit()

    editor.putString(cardFiller.ticker, cardFiller.lastVote.toString()).apply()
}
fun SetDateCardFiller(activity: MainActivity, cardFiller: CardFiller, lastVote: LocalDate, isUpTrend : Boolean){
    val editor =
        activity.getSharedPreferences(
            MySettings.DatabasePlaces.criptos,
            Context.MODE_PRIVATE).edit()

    editor.putString(cardFiller.ticker, lastVote.toString()).apply()
    editor.putString(cardFiller.ticker + "_trend", isUpTrend.toString()).apply()
}