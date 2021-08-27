package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.edtEmail
import kotlinx.android.synthetic.main.activity_sign_up.edtPassword

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUp.setOnClickListener {
            if (edtEmail.text.toString() == "" || edtPassword.text.toString() == "") {
                Toast.makeText(this, "Email or password must not blank", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("email", edtEmail.text.toString())
                intent.putExtra("password", edtPassword.text.toString())
                startActivity(intent)
            }
        }
        tvLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", "")
            intent.putExtra("password", "")
            startActivity(intent)
        }
        tvForgotPassSignUp.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }


    }
}