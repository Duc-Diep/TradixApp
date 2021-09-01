package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tradixapp.R
import com.example.tradixapp.utils.AppPreferences
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        hideActionBar()
        AppPreferences.init(this)
        btnSignUp.setOnClickListener {
            if (edt_email.text.toString() == "" || edt_password.text.toString() == "") {
                Toast.makeText(this, "Email or password must not blank", Toast.LENGTH_SHORT).show()
            } else {
                AppPreferences.userEmail = edt_email.text.toString()
                AppPreferences.userPassword = edt_password.text.toString()
                var intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("email", edt_email.text.toString())
                intent.putExtra("password", edt_password.text.toString())
                startActivity(intent)
                Toast.makeText(this,"Sign up successfully",Toast.LENGTH_SHORT).show()
            }
        }

        tv_login.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", "")
            intent.putExtra("password", "")
            startActivity(intent)
        }
        tv_forgotpass.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }


    }
}