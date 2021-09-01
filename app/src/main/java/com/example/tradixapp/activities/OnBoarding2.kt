package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.utils.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding2.*

class OnBoarding2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding2)
        hideActionBar()
        AppPreferences.init(this)
        btn_next.setOnClickListener {
            startActivity(Intent(this, OnBoarding3::class.java))
        }
        btn_back.setOnClickListener {
            finish()
        }
        btn_skip.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}