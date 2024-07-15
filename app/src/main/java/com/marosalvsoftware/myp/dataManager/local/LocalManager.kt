package com.marosalvsoftware.myp.dataManager.local

import android.content.Context
import com.marosalvsoftware.myp.MainActivity

class LocalManager {
}

fun SaveLocalData(
    activity : MainActivity,
    database: String,
    key1: String,
    subKey1: String,
    value1: String,
    subValue1: String)
{

    val editor =
        activity.getSharedPreferences(
            database,
            Context.MODE_PRIVATE).edit()

    editor.putString(key1, value1).apply()
    editor.putString(key1 + subKey1, subValue1).apply()
}

fun getLocalData(
    activity : MainActivity,
    database : String,
    key1: String) : String?
{
    val sharedPref =
        activity.getSharedPreferences(database, Context.MODE_PRIVATE)
    return sharedPref.getString(key1, "")
}
fun getLocalData(
    activity : MainActivity,
    database : String,
    key1: String,
    subKey1: String) : String?
{
    val sharedPref =
        activity.getSharedPreferences(database, Context.MODE_PRIVATE)
    return sharedPref.getString(key1 + subKey1, "")
}