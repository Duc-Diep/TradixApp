package com.example.tradixapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R

class TitleAdapter(var context: Context?, var listTitle:ArrayList<String>) : RecyclerView.Adapter<TitleAdapter.TitleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TitleViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.title_item,parent,false)
        return TitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: TitleAdapter.TitleViewHolder, position: Int) {
        if (position==0){
            holder.layout.setBackgroundResource(R.drawable.purple_button)
            holder.title.setTextColor(Color.WHITE)
        }
        holder.title.text = listTitle[position]
    }

    override fun getItemCount(): Int {
        if (listTitle!=null){
            return listTitle.size
        }
        return 0
    }
    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout:RelativeLayout = itemView.findViewById(R.id.layout_title_item)
        val title:TextView = itemView.findViewById(R.id.tv_title)
    }
}