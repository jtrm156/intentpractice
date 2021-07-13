package com.example.testproject2

import android.content.Context
import android.content.SharedPreferences

object MysharedPreferences {
    private val My_ACCOUNT : String = "account"

    fun setUserPW_1(context: Context, input: String){
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("password1", input)
        editor.apply()
    }

    fun setUserPW_2(context: Context, input: String){
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("password2", input)
        editor.apply()
    }

    fun getUserPW_1(context: Context): String {
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getString("password1", null).toString()
    }

    fun getUserPW_2(context: Context): String {
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getString("password2", null).toString()
    }

    fun clearUser(context: Context){
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}

