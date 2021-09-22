package com.example.tradixapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tradixapp.R
import com.example.tradixapp.adapters.TitleAdapter
import com.example.tradixapp.objects.Coin
import com.example.tradixapp.objects.Title
import kotlinx.android.synthetic.main.fragment_coin.view.*
import kotlinx.android.synthetic.main.fragment_coin.view.btn_ring
import kotlinx.android.synthetic.main.fragment_coin.view.rcv_title
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.Exception

class CoinFragment : Fragment() {
    lateinit var titleAdapter:TitleAdapter
    lateinit var listTitle:ArrayList<Title>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coin,container,false)
        initAdapter()
        view.rcv_title.adapter = titleAdapter

        view.btn_ring.setOnClickListener {
            view.btn_ring.background.setTint(Color.BLUE)
        }
        view.btn_back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        try {
            val args: CoinFragmentArgs by navArgs()
            var coin:Coin = args.coin
            if (coin!=null){
                view.tv_name.text = coin.name
            }
        }catch (ex:Exception){

        }

        return view
    }

    private fun initAdapter(){
        listTitle = ArrayList()
        listTitle.apply {
            add(Title("General",true))
            add(Title("Technical Section",false))
            add(Title("Markets",false))
            add(Title("Charts",false))
        }
        titleAdapter = TitleAdapter(context,listTitle,"pink")
    }

}