package com.marosalvsoftware.myp

import androidx.compose.ui.graphics.Color
import com.google.gson.annotations.SerializedName
import com.marosalvsoftware.myp.data.local.readFromDatabase
import com.marosalvsoftware.myp.data.local.saveToDatabase
import com.marosalvsoftware.myp.data.online.getCoinCapResp
import com.marosalvsoftware.myp.settings.MySettings
import java.time.LocalDate
import java.util.Locale

data class CardFiller(
    @SerializedName("color")            var color: Color,
    @SerializedName("name")             var name: String,
    @SerializedName("iconID")           var iconID: Int,
    @SerializedName("actualPrice")      var actualPrice: String,
    @SerializedName("ticker")           var ticker: String,
    @SerializedName("voteDateList")     var voteDateList: MutableList<String>,
    @SerializedName("isUptrendList")    var isUptrendList: MutableList<Boolean>
) {
    fun build(card : CardFiller): CardFiller{
        this.color = card.color
        this.name = card.name
        this.iconID = card.iconID
        this.actualPrice = card.actualPrice
        this.ticker = card.ticker
        this.voteDateList = card.voteDateList
        this.isUptrendList = card.isUptrendList
        return this
    }
}

fun getListCardFiller(): List<CardFiller> {
    return listOf(
        Bitcoin,
        Ethereum,
        Binance,
        Solana,
        Polkadot,
        Uniswap,
        Maker,
        //MakerDAO,
        Chainlink,
        Tron,
        Dogecoin,
        Cardano,
        Near,
        Cosmos,
        Avalanche,
        ShibaInu,
        //Arbitrum,
        Fantom,
        //Optimism,
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
        //NotCoin,
        Cronos,
        Decentraland,
        Algorand,
        Litecoin,
        Ripple
    )
}



var Bitcoin = CardFiller(
    color = Color.Yellow,
    name = "Bitcoin",
    iconID = R.drawable.bitcoin,
    actualPrice = "",
    ticker = CryptoListTicker.Bitcoin.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Ethereum = CardFiller(
    color = Color.Cyan,
    name = "Ethereum",
    iconID = R.drawable.ethereum,
    actualPrice = "",
    ticker = CryptoListTicker.Ethereum.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Solana = CardFiller(
    color = Color.Magenta,
    name = "Solana",
    iconID = R.drawable.solana,
    actualPrice = "",
    ticker = CryptoListTicker.Solana.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Binance = CardFiller(
    color = Color.Green,
    name = "Binance",
    iconID = R.drawable.binance_coin,
    actualPrice = "",
    ticker = CryptoListTicker.Binance.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Polkadot = CardFiller(
    color = Color.Blue,
    name = "Polkadot",
    iconID = R.drawable.polkadot,
    actualPrice = "",
    ticker = CryptoListTicker.Polkadot.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Uniswap = CardFiller(
    color = Color.Gray,
    name = "Uniswap",
    iconID = R.drawable.uniswap,
    actualPrice = "",
    ticker = CryptoListTicker.Uniswap.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Maker = CardFiller(
    color = Color.Black,
    name = "Maker",
    iconID = R.drawable.maker,
    actualPrice = "",
    ticker = CryptoListTicker.Maker.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Chainlink = CardFiller(
    color = Color.DarkGray,
    name = "Chainlink",
    iconID = R.drawable.chainlink,
    actualPrice = "",
    ticker = CryptoListTicker.Chainlink.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

//var MakerDAO = CardFiller(
//    color = Color.Magenta,
//    name = "MakerDAO",
//    iconID = R.drawable.dao_maker,
//    actualPrice = "",
//    ticker = CryptoListTicker.MakerDAO.ticker,
//    voteDateList = mutableListOf(LocalDate.MIN.toString()),
//    isUptrendList = mutableListOf(false)
//)

var Litecoin = CardFiller(
    color = Color.Yellow,
    name = "Litecoin",
    iconID = R.drawable.litecoin,
    actualPrice = "",
    ticker = CryptoListTicker.Litecoin.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Ripple = CardFiller(
    color = Color.Cyan,
    name = "Ripple",
    iconID = R.drawable.xrp,
    actualPrice = "",
    ticker = CryptoListTicker.Ripple.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Algorand = CardFiller(
    color = Color.Magenta,
    name = "Algorand",
    iconID = R.drawable.algorand,
    actualPrice = "",
    ticker = CryptoListTicker.Algorand.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Avalanche = CardFiller(
    color = Color.Green,
    name = "Avalanche",
    iconID = R.drawable.avalanche,
    actualPrice = "",
    ticker = CryptoListTicker.Avalanche.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Tron = CardFiller(
    color = Color.Blue,
    name = "Tron",
    iconID = R.drawable.tron,
    actualPrice = "",
    ticker = CryptoListTicker.Tron.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Dogecoin = CardFiller(
    color = Color.Gray,
    name = "Dogecoin",
    iconID = R.drawable.dogecoin,
    actualPrice = "",
    ticker = CryptoListTicker.Dogecoin.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Cardano = CardFiller(
    color = Color.Black,
    name = "Cardano",
    iconID = R.drawable.cardano,
    actualPrice = "",
    ticker = CryptoListTicker.Cardano.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Near = CardFiller(
    color = Color.DarkGray,
    name = "Near",
    iconID = R.drawable.near_protocol,
    actualPrice = "",
    ticker = CryptoListTicker.Near.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Cosmos = CardFiller(
    color = Color.Magenta,
    name = "Cosmos",
    iconID = R.drawable.cosmos,
    actualPrice = "",
    ticker = CryptoListTicker.Cosmos.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var ShibaInu = CardFiller(
    color = Color.Yellow,
    name = "Shiba Inu",
    iconID = R.drawable.shiba,
    actualPrice = "",
    ticker = CryptoListTicker.ShibaInu.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

//var Arbitrum = CardFiller(
//    color = Color.Cyan,
//    name = "Arbitrum",
//    iconID = R.drawable.arbitrum,
//    actualPrice = "",
//    ticker = CryptoListTicker.Arbitrum.ticker,
//    voteDateList = mutableListOf(LocalDate.MIN.toString()),
//    isUptrendList = mutableListOf(false)
//)

var Fantom = CardFiller(
    color = Color.Magenta,
    name = "Fantom",
    iconID = R.drawable.fantom,
    actualPrice = "",
    ticker = CryptoListTicker.Fantom.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

//var Optimism = CardFiller(
//    color = Color.Green,
//    name = "Optimism",
//    iconID = R.drawable.optimism_ethereum,
//    actualPrice = "",
//    ticker = CryptoListTicker.Optimism.ticker,
//    voteDateList = mutableListOf(LocalDate.MIN.toString()),
//    isUptrendList = mutableListOf(false)
//)

var Polygon = CardFiller(
    color = Color.Blue,
    name = "Polygon",
    iconID = R.drawable.polygon_ecosystem_token,
    actualPrice = "",
    ticker = CryptoListTicker.Polygon.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Aave = CardFiller(
    color = Color.Gray,
    name = "Aave",
    iconID = R.drawable.aave,
    actualPrice = "",
    ticker = CryptoListTicker.Aave.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var EthereumClassic = CardFiller(
    color = Color.Black,
    name = "Ethereum Classic",
    iconID = R.drawable.ethereum_classic,
    actualPrice = "",
    ticker = CryptoListTicker.EthereumClassic.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Filecoin = CardFiller(
    color = Color.DarkGray,
    name = "Filecoin",
    iconID = R.drawable.filecoin,
    actualPrice = "",
    ticker = CryptoListTicker.Filecoin.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var EOS = CardFiller(
    color = Color.Magenta,
    name = "EOS",
    iconID = R.drawable.eos,
    actualPrice = "",
    ticker = CryptoListTicker.EOS.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Monero = CardFiller(
    color = Color.Yellow,
    name = "Monero",
    iconID = R.drawable.monero,
    actualPrice = "",
    ticker = CryptoListTicker.Monero.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Stellar = CardFiller(
    color = Color.Cyan,
    name = "Stellar",
    iconID = R.drawable.stellar,
    actualPrice = "",
    ticker = CryptoListTicker.Stellar.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Curve = CardFiller(
    color = Color.Magenta,
    name = "Curve",
    iconID = R.drawable.curve_dao_token,
    actualPrice = "",
    ticker = CryptoListTicker.Curve.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Zcash = CardFiller(
    color = Color.Green,
    name = "Zcash",
    iconID = R.drawable.zcash,
    actualPrice = "",
    ticker = CryptoListTicker.Zcash.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var InternetComputer = CardFiller(
    color = Color.Blue,
    name = "Internet Computer",
    iconID = R.drawable.internet_computer,
    actualPrice = "",
    ticker = CryptoListTicker.InternetComputer.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var TheGraph = CardFiller(
    color = Color.Gray,
    name = "The Graph",
    iconID = R.drawable.the_graph,
    actualPrice = "",
    ticker = CryptoListTicker.TheGraph.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var TheSandbox = CardFiller(
    color = Color.Black,
    name = "The Sandbox",
    iconID = R.drawable.the_sandbox,
    actualPrice = "",
    ticker = CryptoListTicker.TheSandbox.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Chiliz = CardFiller(
    color = Color.DarkGray,
    name = "Chillz",
    iconID = R.drawable.chiliz,
    actualPrice = "",
    ticker = CryptoListTicker.Chiliz.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Cronos = CardFiller(
    color = Color.Magenta,
    name = "Cronos",
    iconID = R.drawable.bonded_cronos,
    actualPrice = "",
    ticker = CryptoListTicker.Cronos.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

var Decentraland = CardFiller(
    color = Color.Yellow,
    name = "Decentraland",
    iconID = R.drawable.decentraland,
    actualPrice = "",
    ticker = CryptoListTicker.Decentraland.ticker,
    voteDateList = mutableListOf(LocalDate.MIN.toString()),
    isUptrendList = mutableListOf(false)
)

//var NotCoin = CardFiller(
//    color = Color.Cyan,
//    name = "NotCoin",
//    iconID = R.drawable.notcoin,
//    actualPrice = "",
//    ticker = CryptoListTicker.NotCoin.ticker,
//    voteDateList = mutableListOf(LocalDate.MIN.toString()),
//    isUptrendList = mutableListOf(false)
//)


enum class CryptoListTicker(val ticker: String) {
    Bitcoin("BTC"),
    Ethereum("ETH"),
    Litecoin("LTC"),
    Binance("BNB"),
    Solana("SOL"),
    Ripple("XRP"),
    Polkadot("DOT"),
    Tron("TRX"),
    Dogecoin("DOGE"),
    Avalanche("AVAX"),
    Uniswap("UNI"),
    Maker("MKR"),
    //MakerDAO("DAO"),
    Chainlink("LINK"),
    ShibaInu("SHIB"),
    Cardano("ADA"),
    Near("NEAR"),
    Cosmos("ATOM"),
    //Arbitrum("ARB"),
    Fantom("FTM"),
    //Optimism("OP"),
    Polygon("MATIC"),
    Aave("AAVE"),
    EthereumClassic("ETC"),
    Filecoin("FIL"),
    EOS("EOS"),
    Monero("XMR"),
    Stellar("XLM"),
    Curve("CRV"),
    Zcash("ZEC"),
    InternetComputer("ICP"),
    TheGraph("GRT"),
    TheSandbox("SAND"),
    Chiliz("CHZ"),
    //NotCoin("NOT"),
    Cronos("CRO"),
    Decentraland("MANA"),
    Algorand("ALGO")
}


fun updatedCardFiller(activity: MainActivity): List<CardFiller> {
    //TODO Aggiornare anche l'ultima votazione fatta dall'utente tramite Firebase oppure una variabile salvata localmente


    /**Estrae la lista delle card da utilizzare ed aggiorna i dati salvati in locale */
    val updatedList = getListCardFiller()
    for (cardFiller in updatedList) {
        val updatedCard = getCardFillerSaved(activity, cardFiller)
        cardFiller.build(updatedCard)
    }

    return updatedList
}

fun saveCardFiller(activity: MainActivity, cardFiller: CardFiller) {
//Tested Working
    saveToDatabase(activity, MySettings.DatabasePlaces.CRYPTO, cardFiller.ticker, cardFiller)
}

private fun getCardFillerSaved(activity: MainActivity, cardFiller: CardFiller): CardFiller {

    val out = readFromDatabase<CardFiller>(
    activity,
    MySettings.DatabasePlaces.CRYPTO,
    cardFiller.ticker
    )

    return out ?: cardFiller
}
