package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.objects.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding2.*
import kotlinx.android.synthetic.main.activity_on_boarding2.btnNext
import kotlinx.android.synthetic.main.activity_on_boarding2.btnSkip

class OnBoarding2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding2)
        AppPreferences.init(this)
        btnNext.setOnClickListener {
            startActivity(Intent(this, OnBoarding3::class.java))
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