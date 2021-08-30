package com.example.tradixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tradixapp.R
import com.example.tradixapp.adapters.TitleAdapter
import kotlinx.android.synthetic.main.fragment_coin.view.rcv_title

class CoinFragment : Fragment() {
    lateinit var titleAdapter:TitleAdapter
    fun newInstance():CoinFragment {
        val args = Bundle()

        val fragment = CoinFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coin,container,false)
        initAdapter()
        view.rcv_title.adapter = titleAdapter
        return view
    }
    fun initAdapter(){
        var listTitle = arrayListOf("General","Technical Section","Markets","Charts")
        titleAdapter = TitleAdapter(context,listTitle)
    }
}