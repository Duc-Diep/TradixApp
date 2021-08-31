package com.example.tradixapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import com.example.tradixapp.objects.MenuItem

class MenuAdapter(var context: Context?, var listItem:ArrayList<MenuItem>):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    val MENU_ITEM_TYPE_1:Int = 1
    val MENU_ITEM_TYPE_2:Int = 2
    val MENU_ITEM_TYPE_3:Int = 3
    val MENU_ITEM_TYPE_4:Int = 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        when(viewType){
            MENU_ITEM_TYPE_1 ->{
                var view:View = LayoutInflater.from(context).inflate(R.layout.menu_item_type_1,parent,false)
                return MenuViewHolder(view)
            }
            MENU_ITEM_TYPE_2 ->{
                var view:View = LayoutInflater.from(context).inflate(R.layout.menu_item_type_2,parent,false)
                return MenuViewHolder(view)
            }
            MENU_ITEM_TYPE_3 ->{
                var view:View = LayoutInflater.from(context).inflate(R.layout.menu_item_type_3,parent,false)
                return MenuViewHolder(view)
            }
            MENU_ITEM_TYPE_4 ->{
                var view:View = LayoutInflater.from(context).inflate(R.layout.menu_item_type_4,parent,false)
                return MenuViewHolder(view)
            }
            else -> {
                var view:View = LayoutInflater.from(context).inflate(R.layout.menu_item_type_4,parent,false)
                return MenuViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        var menuItem = listItem[position]
        when(holder.itemViewType){
            MENU_ITEM_TYPE_1,MENU_ITEM_TYPE_2 ->{
                holder.icon.setImageResource(menuItem.icon)
                holder.title.text = menuItem.title
            }
            MENU_ITEM_TYPE_3 -> holder.title.text = menuItem.title
            MENU_ITEM_TYPE_4 -> {}
        }
    }

    override fun getItemCount(): Int {
        if (listItem!=null){
            return listItem.size
        }
        return 0
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title:TextView = itemView.findViewById(R.id.tv_menu_title)
        val icon:ImageView = itemView.findViewById(R.id.menu_item_icon)
    }

    override fun getItemViewType(position: Int): Int {
        var menuItem = listItem[position]
        return when(menuItem.type){
            1-> MENU_ITEM_TYPE_1
            2-> MENU_ITEM_TYPE_2
            3-> MENU_ITEM_TYPE_3
            4-> MENU_ITEM_TYPE_4
            else -> 0
        }

    }

}