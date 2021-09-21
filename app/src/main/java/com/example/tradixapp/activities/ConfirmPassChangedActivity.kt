package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tradixapp.R
import com.example.tradixapp.utils.AppPreferences
import kotlinx.android.synthetic.main.activity_confirm_pass_changed.*


class ConfirmPassChangedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        AppPreferences.init(this)
        setContentView(R.layout.activity_confirm_pass_changed)
        btn_login_cf.setOnClickListener {
            AppPreferences.userPassword = "123"
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", AppPreferences.userEmail)
            intent.putExtra("password", AppPreferences.userPassword)
            startActivity(intent)
        }
    }

}