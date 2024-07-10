package com.marosalvsoftware.myp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class MySettings {
    data object NavigationBarSettings : MySettings()
    {
        /**Percentage of the screen*/
        val heightFloat: Float = 0.10f
        /**Absolute Value*/
        val heightDp: Dp = 90.dp
    }
    data object ColorThemeLight : MySettings(){
        val primary : Color = Color(0xFFB39DDB)
        val secondary : Color = Color(0xFF353436)
        val tertiary : Color = Color(0xFFFFF59D)
        val background : Color = Color(0xFFFFFBFE)
        val icons : Color = Color(0xFF1C1B1F)
        val text : Color = Color(0xFF1F1D22)

    }

    data object Paddings : MySettings(){
        val small : Dp = 8.dp
        val medium : Dp = 16.dp
        val large : Dp = 32.dp
    }

    data object Sizes : MySettings(){
        val headerBand : Dp = 130.dp
        val iconSizes : Dp = 48.dp
        data object MyTextSizes : MySettings(){
            val small : Dp = 12.dp
            val medium : Dp = 16.dp
            val large : Dp = 24.dp
        }
    }
}