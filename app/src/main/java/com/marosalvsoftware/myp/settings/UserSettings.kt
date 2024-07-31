package com.marosalvsoftware.myp.settings

data class Set_List(
    val usedSet_List: List<Setting> = listOf(

    )
)

data class Setting(
    val name: String,
    val value : Any
)



enum class Lang{
    ITA,
    ENG,
    SPA,
    DEU,
    FRA
}

enum class ThemeSelection{
    DARK,
    LIGHT,
    SYSTEM_SELECTED
}

private val DefaultLanguage= Setting(
    name = "Language",
    value = Lang.ENG
)

private val DefaultTheme = Setting(
    name = "Theme",
    value = ThemeSelection.SYSTEM_SELECTED
)

val DefaultListSettings = Set_List(
    usedSet_List = listOf(DefaultLanguage, DefaultTheme)
)