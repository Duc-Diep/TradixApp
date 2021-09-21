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
import com.example.tradixapp.objects.Title

class TitleAdapter(var context: Context?, var listTitle:ArrayList<Title>,var colorTitle:String) : RecyclerView.Adapter<TitleAdapter.TitleViewHolder>() {
    private var indexTitle:Int =0
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TitleViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.title_item,parent,false)
        return TitleViewHolder(view)
    }



    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        var title = listTitle[position]
        if (title.checked){
            if (colorTitle=="green"){
                holder.layout.setBackgroundResource(R.drawable.green_button)
            }else{
                holder.layout.setBackgroundResource(R.drawable.purple_button)
            }
            holder.title.setTextColor(Color.WHITE)
        }else{
            holder.layout.setBackgroundResource(R.color.white_two)
            holder.title.setTextColor(Color.BLACK)

        }
        holder.itemView.setOnClickListener {
            listTitle[indexTitle].checked = false
            listTitle[position].checked = true
            indexTitle = position
            notifyDataSetChanged()
        }
        holder.title.text = listTitle[position].name
    }

    override fun getItemCount(): Int {
            return listTitle.size
    }
    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout:RelativeLayout = itemView.findViewById(R.id.layout_title_item)
        val title:TextView = itemView.findViewById(R.id.tv_title)
    }
}