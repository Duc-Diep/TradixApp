package com.example.tradixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.tradixapp.R
import com.example.tradixapp.adapters.NewsAdapter
import com.example.tradixapp.adapters.TitleAdapter
import com.example.tradixapp.objects.News
import com.example.tradixapp.objects.Title
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment() : Fragment() {
    lateinit var titleAdapter: TitleAdapter
    lateinit var newsAdapter: NewsAdapter
    lateinit var listNews: ArrayList<News>
    lateinit var listTitle: ArrayList<Title>
    lateinit var controller: NavController
    private val navBuilder = NavOptions.Builder()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_news, container, false)
        initAdapter()

        view.btn_back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        controller = findNavController()
        view.rcv_news.apply {
            setHasFixedSize(true)
            adapter = newsAdapter
        }
        view.rcv_title.apply {
            setHasFixedSize(true)
            adapter = titleAdapter
        }
        return view
    }

    private fun initAdapter() {
        listTitle = ArrayList()
        listTitle.apply {
            add(Title("EDITORIAL",true))
            add(Title("CRYPTO NEWS",false))
            add(Title("RAW MATERIAL",false))
            add(Title("ECONOMICS",false))
        }
        titleAdapter = TitleAdapter(context, listTitle,"green")
        listNews = ArrayList()
        listNews.apply {
            add(
                News(
                    R.drawable.item_1,
                    "ALT -3,87%",
                    "ATLANTIA",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    true
                )
            )
            add(
                News(
                    R.drawable.item_2,
                    "HKD -2,13%",
                    "XIAOMI",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    false
                )
            )
            add(
                News(
                    R.drawable.item_3,
                    "AAPL -0,91%",
                    "APPLE",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    false
                )
            )
            add(
                News(
                    R.drawable.item_1,
                    "ALT -3,87%",
                    "ATLANTIA",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    true
                )
            )
            add(
                News(
                    R.drawable.item_2,
                    "HKD -2,13%",
                    "XIAOMI",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    false
                )
            )
            add(
                News(
                    R.drawable.item_3,
                    "AAPL -0,91%",
                    "APPLE",
                    "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
                    "3 Sept 2020",
                    false
                )
            )
        }
        newsAdapter = NewsAdapter(context, listNews)
        newsAdapter.setOnItemClick {
            val action = NewsFragmentDirections.actionFragmentNewsToFragmentNewsDetail(it)
            val navOptions = navBuilder.setPopUpTo(id, false).build()
            controller.navigate(action,navOptions)
        }
    }
}