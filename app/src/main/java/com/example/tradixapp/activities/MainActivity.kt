package com.example.tradixapp.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_main.*


fun AppCompatActivity.hideActionBar() {
    supportActionBar?.hide()
}

class MainActivity : AppCompatActivity() {
    lateinit var navController:NavController
    private val navBuilder = NavOptions.Builder()
    lateinit var navHostFragment:NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideActionBar()
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
        bottom_navi.setupWithNavController(navController)
        bottom_navi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_home -> navController.navigate(R.id.fragment_home)
                R.id.fragment_news -> navController.navigate(R.id.fragment_news)
                R.id.fragment_coin -> navController.navigate(R.id.fragment_coin)
                R.id.fragment_customer -> navController.navigate(R.id.fragment_customer)
            }
            true
        }
    }

    override fun onBackPressed() {
        val navHostManager = navHostFragment.childFragmentManager
        if (navHostManager.backStackEntryCount==0){
            var dialog = AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Do you want to close this app?")
                .setNegativeButton("No") { _, _ -> }
                .setPositiveButton("Yes") { _, _ -> finish() }
                .create()
            dialog.show()
        }else{
            super.onBackPressed()
        }
    }
}