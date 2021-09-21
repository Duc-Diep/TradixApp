package com.example.tradixapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tradixapp.utils.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding3.*
import kotlinx.android.synthetic.main.activity_on_boarding3.view.*

class OnBoarding3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_on_boarding3,container,false)
        view.btn_start.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(context, LoginActivity::class.java))
            requireActivity().finish()
        }
        view.btn_back.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        view.btn_skip.setOnClickListener {
            AppPreferences.isCompleteTutorial = true
            startActivity(Intent(context, LoginActivity::class.java))
            requireActivity().finish()
        }
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppPreferences.init(context)

    }
}