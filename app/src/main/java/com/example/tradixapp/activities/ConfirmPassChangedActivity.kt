package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_confirm_pass_changed.*

class ConfirmPassChangedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_pass_changed)
        btnLoginCf.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}