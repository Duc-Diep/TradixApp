package com.example.tradixapp.fragments

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
import com.example.tradixapp.objects.News
import com.example.tradixapp.objects.Title
import kotlinx.android.synthetic.main.fragment_news_details.view.*
import java.lang.Exception

class NewsDetailsFragment : Fragment() {
    lateinit var titleAdapter: TitleAdapter
    lateinit var listTitle: ArrayList<Title>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_news_details, container, false)

        view.btn_back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        initAdapter()

        view.rcv_title_news_detail.apply {
            setHasFixedSize(true)
            adapter = titleAdapter
        }

        try {
            val args: NewsDetailsFragmentArgs by navArgs()
            var news: News = args.news
            if (news != null) {
                view.tv_name.text = news.name
            }
        } catch (ex: Exception) {

        }
        return view
    }
    fun initAdapter(){
        listTitle = ArrayList()
        listTitle.apply {
            add(Title("EDITORIAL",true))
            add(Title("CRYPTO NEWS",false))
            add(Title("RAW MATERIAL",false))
            add(Title("ECONOMICS",false))
        }
        titleAdapter = TitleAdapter(context, listTitle,"green")
    }
}