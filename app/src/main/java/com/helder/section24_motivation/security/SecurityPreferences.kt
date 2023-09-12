package com.helder.section24_motivation.security

import android.content.Context

class SecurityPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        sharedPreferences.edit().putString(key, str).apply()
    }

    fun getString(key: String): String = sharedPreferences.getString(key, "") ?: ""
}