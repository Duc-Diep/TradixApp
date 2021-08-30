package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.utils.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding3.*

class OnBoarding3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding3)
        hideActionBar()
        AppPreferences.init(this)
        btnStart.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btnBack.setOnClickListener {
            finish()
        }
        btnSkip.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}