package com.example.tradixapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.tradixapp.R
import com.example.tradixapp.objects.User
import com.example.tradixapp.adapters.TitleAdapter
import com.example.tradixapp.adapters.UserAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    lateinit var titleAdapter:TitleAdapter
    lateinit var userAdapter:UserAdapter
    lateinit var listUser:ArrayList<User>
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
        initAdapter()
        view.rcv_title.adapter = titleAdapter
        view.rcv_item_home.apply {
            adapter = userAdapter
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }

        userAdapter.setCallBack {
            Toast.makeText(context,"${listUser[it]}",Toast.LENGTH_SHORT).show()
        }

        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                userAdapter.removeItem(viewHolder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        itemTouchHelper.attachToRecyclerView(view.rcv_item_home)



        view.btnLoadMore.setOnClickListener {
            listUser.apply {
                for (i in 1..10 ){
                    add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
                }
            }
            view.progress_bar.visibility = View.VISIBLE
            userAdapter.notifyDataSetChanged()
            view.progress_bar.visibility = View.GONE
        }

        return view
    }
    fun initAdapter(){
        var listTitle = arrayListOf("INDEX","SHARES","CURRENCIES","FUTURES","CRYPTO")
        titleAdapter = TitleAdapter(context,listTitle)
        listUser = ArrayList()
        listUser.apply {
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            add(User("Điệp","NYSE","12:21:32","23.03","+203 (+1,04%)"))
        }
        userAdapter = UserAdapter(context,listUser)
    }

}