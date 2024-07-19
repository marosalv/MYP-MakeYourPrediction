package com.marosalvsoftware.myp.data.local

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.marosalvsoftware.myp.CardFiller
import com.marosalvsoftware.myp.MainActivity

inline fun <reified T> saveToDatabase (
    activity: MainActivity,
    database: String,
    key1: String,
    value1: T
){
    val sharedPref = activity.getSharedPreferences(database, Context.MODE_PRIVATE)

    val editor = sharedPref.edit()
    val jsonObj = Gson().toJson(value1)

    editor.putString(key1, jsonObj)
    editor.apply()
}

inline fun <reified T>readFromDatabase(
    activity: MainActivity,
    database: String,
    key1: String
): T?
{

    val sharedPref = activity.getSharedPreferences(database, Context.MODE_PRIVATE)
    val jsonDB = sharedPref.getString(key1, "")

    if(jsonDB.isNullOrEmpty()) return null

    return Gson().fromJson(jsonDB, T::class.java)
}