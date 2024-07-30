package com.marosalvsoftware.myp

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class MySettings {
    data object NavigationBarSettings : MySettings()
    {
        /**Absolute Value*/
        val heightDp: Dp = 90.dp
    }
    data object ColorThemeLight : MySettings(){
        val primary : Color = Color(0xFF2E83C7)
        val secondary : Color = Color(0xFF27702B)
        val tertiary : Color = Color(0xFFE6F089)
        val background : Brush = Brush.verticalGradient(listOf(
            Color(0xFFB4DEFF),
            Color(0xFF6DBEFF)
        ))
        val icons : Color = Color(0xFF1C1B1F)
        val text : Color = Color(0xFF1F1D22)
        val downTrend : Color = Color(0xFFB61B29)
        val upTrend : Color = Color(0xFF03C77C)
        val cardBacground : Color = Color(0xFFB4DEFF)


    }

    data object DatabasePlaces: MySettings(){
        const val CRIPTO : String = "441"
         }

    data object Paddings : MySettings(){
        val small : Dp = 8.dp
        val medium : Dp = 16.dp
        val large : Dp = 32.dp
    }

    data object Sizes : MySettings(){
        val headerBand : Dp = 130.dp
        val iconSizes : Dp = 48.dp
        val cardSize_little : Dp = 70.dp
        val cardSize_big : Dp = 180.dp

        data object MyTextSizes : MySettings(){
            val small : Dp = 12.dp
            val medium : Dp = 16.dp
            val large : Dp = 24.dp
        }
    }
}