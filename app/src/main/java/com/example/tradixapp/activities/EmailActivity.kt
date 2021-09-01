package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        setContentView(R.layout.activity_email)
        btn_send_email.setOnClickListener {
            startActivity(Intent(this, ConfirmPassChangedActivity::class.java))
        }
    }
    override fun onStart() {
        super.onStart()
        var handler = Handler(mainLooper)
        var thread = Thread{
            btn_send_email.isClickable = false
            var count:Int = 5
            while (count!=0){
                Thread.sleep(1000)
                count--
                handler.post{
                    tv_wait.text = "Wait $count seconds before sending it"
                }
            }
            handler.post{
                tv_wait.text = "You can send email to reset password"
            }
            btn_send_email.isClickable = true
        }
        thread.start()
    }
}