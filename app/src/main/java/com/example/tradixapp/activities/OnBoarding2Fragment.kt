package com.example.tradixapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tradixapp.utils.AppPreferences
import com.example.tradixapp.R
import kotlinx.android.synthetic.main.activity_on_boarding2.view.*

class OnBoarding2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_on_boarding2,container,false)
        view.btn_next.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_left,R.anim.slide_out_left,R.anim.slide_in_right)
                ?.replace(R.id.frame_tutorial, OnBoarding3Fragment())?.addToBackStack(null)
                ?.commit()
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