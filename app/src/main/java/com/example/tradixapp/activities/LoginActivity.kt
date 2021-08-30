package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        setContentView(R.layout.activity_login)

        tvForgotPass.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }
        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var email = intent?.getStringExtra("email")
        var password = intent?.getStringExtra("password")
        edtEmail.setText(email)
        edtPassword.setText(password)
    }

    override fun onBackPressed() {
        var dialog = AlertDialog.Builder(this)
            .setTitle("Confirm")
            .setMessage("Do you want to close this app?")
            .setNegativeButton("No") { _, _ -> }
            .setPositiveButton("Yes") { _, _ -> finish() }
            .create()
        dialog.show()
    }
}