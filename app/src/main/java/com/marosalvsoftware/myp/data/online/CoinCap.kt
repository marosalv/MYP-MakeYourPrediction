package com.marosalvsoftware.myp.data.online

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.net.URL

const val COINCAP_URL = "https://api.coincap.io/v2/assets"


data class CoinCapResp (
    @field:SerializedName("data"              ) var data              : List<CoinCap> = listOf(),
    @field:SerializedName("timestamp"         ) var timestamp         : Long                = 0
)


data class CoinCap (
    @field:SerializedName("id"                ) var id                : String? = "",
    @field:SerializedName("rank"              ) var rank              : String? = "",
    @field:SerializedName("symbol"            ) var symbol            : String? = "",
    @field:SerializedName("name"              ) var name              : String? = "",
    @field:SerializedName("supply"            ) var supply            : String? = "",
    @field:SerializedName("maxSupply"         ) var maxSupply         : String? = "",
    @field:SerializedName("marketCapUsd"      ) var marketCapUsd      : String? = "",
    @field:SerializedName("volumeUsd24Hr"     ) var volumeUsd24Hr     : String? = "",
    @field:SerializedName("priceUsd"          ) var priceUsd          : String? = "",
    @field:SerializedName("changePercent24Hr" ) var changePercent24Hr : String? = "",
    @field:SerializedName("vwap24Hr"          ) var vwap24Hr          : String? = "",
    @field:SerializedName("explorer"          ) var explorer          : String? = ""
)

/**
 * Use with Thread{}.start() to remove from main app thread
 */
private fun getCoinCapJSON() : String?{
    return URL(COINCAP_URL).readText()
}
/**
 * Use with Thread{}.start() to remove from main app thread
 */
fun getCoinCapResp() : CoinCapResp?{
    return Gson().fromJson(getCoinCapJSON(), CoinCapResp::class.java)
}