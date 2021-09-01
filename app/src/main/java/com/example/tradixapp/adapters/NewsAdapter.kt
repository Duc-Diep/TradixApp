package com.example.tradixapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import com.example.tradixapp.objects.News

class NewsAdapter(var context: Context?, var listNews:ArrayList<News>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    lateinit var onClick:(News)->Unit
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(view)
    }

    fun setOnItemClick(callBack:(News)->Unit){
        onClick = callBack
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = listNews[position]
        holder.imgAvatar.setImageResource(news.avatar)
        holder.tvSale.text = news.sale
        holder.tvName.text = news.name
        holder.tvTime.text = news.time
        holder.tvDescription.text = news.description
        if (news.alert){
            holder.imgAlert.visibility = View.VISIBLE
        }else{
            holder.imgAlert.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            onClick.invoke(news)
        }
    }



    override fun getItemCount(): Int {
        if(listNews!=null){
            return listNews.size
        }
        return 0
    }
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAvatar:ImageView = itemView.findViewById(R.id.news_item_img)
        val imgAlert:ImageView = itemView.findViewById(R.id.news_item_alert)
        val tvSale:TextView = itemView.findViewById(R.id.news_item_sale)
        val tvName:TextView = itemView.findViewById(R.id.news_item_name)
        val tvDescription:TextView = itemView.findViewById(R.id.news_item_description)
        val tvTime:TextView = itemView.findViewById(R.id.news_item_time)
    }
}