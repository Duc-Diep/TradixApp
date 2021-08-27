package com.example.tradixapp.objects

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "SpinKotlin"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_COMPLETE_TUTORIAL = Pair("is_complete", false)
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
}