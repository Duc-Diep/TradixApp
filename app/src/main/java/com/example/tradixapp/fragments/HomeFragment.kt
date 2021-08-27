package com.example.tradixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.tradixapp.R
import com.example.tradixapp.User
import com.example.tradixapp.adapters.TitleAdapter
import com.example.tradixapp.adapters.UserAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    lateinit var titleAdapter:TitleAdapter
    lateinit var userAdapter:UserAdapter
    fun newInstance(): HomeFragment {
        val args = Bundle()
        val fragment = HomeFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        //adater title
        var listTitle = arrayListOf("INDEX","SHARES","CURRENCIES","FUTURES","CRYPTO")
        titleAdapter = TitleAdapter(context,listTitle)
        view.rcv_title.adapter = titleAdapter

        var listUser:ArrayList<User> = ArrayList()
        listUser.apply {
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","323.323","+203 (+1,04%)"))
        }
        userAdapter = UserAdapter(context,listUser)
        view.rcv_item_home.adapter = userAdapter

        view.rcv_item_home.addItemDecoration(DividerItemDecoration(context, VERTICAL))
        userAdapter.setCallBack {
            Toast.makeText(context,"${listUser[it]}",Toast.LENGTH_SHORT).show()
        }
        return view
    }

}