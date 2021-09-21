package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tradixapp.R
import com.example.tradixapp.utils.AppPreferences

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        setContentView(R.layout.activity_tutorial)
        AppPreferences.init(this)
        if (AppPreferences.isCompleteTutorial){
            var intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }else{
            getFragment(OnBoarding1Fragment())
        }
    }
    private fun getFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_tutorial,fragment).addToBackStack(null).commit()
    }
}