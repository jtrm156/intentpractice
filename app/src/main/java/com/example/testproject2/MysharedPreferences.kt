package com.example.testproject2

import android.content.Context
import android.content.SharedPreferences

object MysharedPreferences {
    private val My_ACCOUNT : String = "account"

    fun setUserPass(context: Context, input: String){
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, 0)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("password", input)
        editor.commit()
    }
    fun getUserPass(context: Context, input: String): String {
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, 0)
        return prefs.getString("password", "").toString()
    }

    fun clearUser(context: Context){
        val prefs : SharedPreferences = context.getSharedPreferences(My_ACCOUNT, 0)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.commit()
    }
}