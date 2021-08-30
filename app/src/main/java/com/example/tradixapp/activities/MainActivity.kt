package com.example.tradixapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.tradixapp.R
import com.example.tradixapp.fragments.CoinFragment
import com.example.tradixapp.fragments.CustomeFragment
import com.example.tradixapp.fragments.HomeFragment
import com.example.tradixapp.fragments.NewsFragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*
fun AppCompatActivity.hideActionBar() {
    supportActionBar?.hide()
}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideActionBar()
        supportFragmentManager.beginTransaction().replace(R.id.frame_main,HomeFragment()).commit()
        bottom_navi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> getFragment(HomeFragment())
                R.id.news -> getFragment(NewsFragment())
                R.id.chart -> getFragment(CoinFragment())
                R.id.customer -> getFragment(CustomeFragment())
            }
            true
        }
    }
    private fun getFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_main,fragment).addToBackStack(null).commit()
    }
}