package com.example.tradixapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tradixapp.R
import com.example.tradixapp.utils.AppPreferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        AppPreferences.init(this)
        setContentView(R.layout.activity_login)

        tvForgotPass.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }
        tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btn_login.setOnClickListener {
            val email = edt_email.text.toString()
            val pass = edt_password.text.toString()
            if (email==AppPreferences.userEmail&&pass==AppPreferences.userPassword){
                var intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Incorrect account or password",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var email = intent?.getStringExtra("email")
        var password = intent?.getStringExtra("password")
        edt_email.setText(email)
        edt_password.setText(password)
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