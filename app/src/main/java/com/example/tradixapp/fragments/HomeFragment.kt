package com.example.tradixapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.tradixapp.R
import com.example.tradixapp.objects.Coin
import com.example.tradixapp.adapters.TitleAdapter
import com.example.tradixapp.adapters.CoinAdapter
import com.example.tradixapp.objects.Title
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    lateinit var titleAdapter:TitleAdapter
    lateinit var coinAdapter:CoinAdapter
    lateinit var listTitle:ArrayList<Title>
    lateinit var listCoin:ArrayList<Coin>
    lateinit var controller:NavController
    var indexTitle:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        //khởi tạo rcv title
        initAdapter()
        controller = findNavController()
        view.rcv_title.adapter = titleAdapter

        view.btn_ring.setOnClickListener {
            view.btn_ring.background.setTint(Color.BLUE)
        }
        //khởi tạo rcv item coin

        view.rcv_item_home.apply {
            adapter = coinAdapter
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }


        // itemTouchHelper xóa item
        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                coinAdapter.removeItem(viewHolder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        itemTouchHelper.attachToRecyclerView(view.rcv_item_home)


            //loadmore
        view.btnLoadMore.setOnClickListener {
            listCoin.apply {
                for (i in 1..10 ){
                    add(Coin("USD","NYSE","12:21:32","23.03","+203 (+1,04%)"))
                }
            }
            coinAdapter.notifyDataSetChanged()
        }


        return view
    }
    fun initAdapter(){
        //init title
        listTitle = ArrayList()
        listTitle.apply {
            add(Title("INDEX",true))
            add(Title("SHARES",false))
            add(Title("CURRENCIES",false))
            add(Title("FUTURES",false))
            add(Title("CRYPTO",false))
        }
        titleAdapter = TitleAdapter(context,listTitle,"pink")



        listCoin = ArrayList()
        listCoin.apply {
            for (i in 1..10 ){
                add(Coin("USD","NYSE","12:21:32","23.03","+203 (+1,04%)"))
            }
        }
        coinAdapter = CoinAdapter(context,listCoin)
        coinAdapter.setOnItemClick {
//            Toast.makeText(context,"${listCoin[it]}",Toast.LENGTH_SHORT).show()
            var coin = listCoin[it]
            coin.name = coin.name + " $it"
            val action = HomeFragmentDirections.actionFragmentHomeToFragmentCoin(coin)
            controller.navigate(action)
        }
    }

}