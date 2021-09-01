package com.example.tradixapp.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "AppPreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_COMPLETE_TUTORIAL = Pair("is_complete", false)
    private val USER_EMAIL = Pair("email","admin")
    private val USER_PASSWORD = Pair("password","123456")
    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit() //SharedPreferences.Editor editor
        operation(editor)
        editor.apply()
    }

    var isCompleteTutorial: Boolean
        get() = preferences.getBoolean(IS_COMPLETE_TUTORIAL.first, IS_COMPLETE_TUTORIAL.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_COMPLETE_TUTORIAL.first, value)
        }

    var userEmail:String
    get() = preferences.getString(USER_EMAIL.first, USER_EMAIL.second).toString()
    set(value) = preferences.edit {
        it.putString(USER_EMAIL.first,value)
    }

    var userPassword:String
    get() = preferences.getString(USER_PASSWORD.first, USER_PASSWORD.second).toString()
    set(value) = preferences.edit {
        it.putString(USER_PASSWORD.first,value)
    }
}