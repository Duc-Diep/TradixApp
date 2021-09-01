package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.utils.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding1.*

class OnBoarding1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding1)
        hideActionBar()
        AppPreferences.init(this)
        if (AppPreferences.isCompleteTutorial){
            var intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
        btn_next.setOnClickListener {
            startActivity(Intent(this, OnBoarding2::class.java))
        }
        btn_skip.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}