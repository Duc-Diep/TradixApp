package com.example.tradixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tradixapp.R
import com.example.tradixapp.adapters.MenuAdapter
import com.example.tradixapp.objects.MenuItem
import kotlinx.android.synthetic.main.fragment_custome.view.*

class CustomeFragment :Fragment() {
    lateinit var menuAdapter:MenuAdapter
    lateinit var listItem:ArrayList<MenuItem>
    fun newInstance():CustomeFragment {
        val args = Bundle()

        val fragment = CustomeFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_custome,container,false)
        initAdapter()
        view.rcv_menu.apply {
            setHasFixedSize(true)
            adapter = menuAdapter
        }
        return view
    }

    private fun initAdapter() {
        listItem = ArrayList()
        listItem.apply {
            add(MenuItem(1,R.drawable.icons_8_alarm,"Alerts"))
            add(MenuItem(1,R.drawable.icons_8_left_and_right_arrows,"Predictions"))
            add(MenuItem(1,R.drawable.icons_8_pin,"Saved elements"))
            add(MenuItem(1,R.drawable.icons_8_no_entry,"Remove Ads"))
            add(MenuItem(4,0,""))
            add(MenuItem(3,0,"Tools"))
            add(MenuItem(2,R.drawable.icons_8_profit_2,"Select Stocks"))
            add(MenuItem(2,R.drawable.icons_8_swap,"Currency Exchange"))
            add(MenuItem(2,R.drawable.icons_8_video_call,"Webinar"))
            add(MenuItem(2,R.drawable.icons_8_rent,"Best Broker"))
            add(MenuItem(4,0,""))
            add(MenuItem(3,0,"Markets"))
            add(MenuItem(2,R.drawable.icons_8_profit_2,"Select Stocks"))
            add(MenuItem(2,R.drawable.icons_8_swap,"Currency Exchange"))
            add(MenuItem(2,R.drawable.icons_8_video_call,"Webinar"))
            add(MenuItem(2,R.drawable.icons_8_rent,"Best Broker"))
        }
        menuAdapter = MenuAdapter(context,listItem)
    }
}