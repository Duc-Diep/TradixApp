package com.example.tradixapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import com.example.tradixapp.objects.Coin

class CoinAdapter(var context: Context?, var listCoin:ArrayList<Coin>):RecyclerView.Adapter<CoinAdapter.UserViewHolder>() {
    var onClick:((Int)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.coin_item,parent,false)
        return UserViewHolder(view)
    }

    fun setOnItemClick(callBack : (Int)->Unit) {
        onClick = callBack
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = listCoin[position]
        holder.tvName.text = "${user.name} $position"
        holder.tvAddress.text = user.address
        holder.tvTime.text = user.time
        holder.tvCurrentPoint.text = user.point
        holder.tvAddPoint.text = user.addPoint
        holder.itemView.setOnClickListener{
            onClick?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        if (listCoin!=null){
            return listCoin.size
        }
        return 0
    }
    fun removeItem(viewHolder: RecyclerView.ViewHolder){
        listCoin.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName:TextView = itemView.findViewById(R.id.tv_name)
        val tvAddress:TextView = itemView.findViewById(R.id.tv_address)
        val tvTime:TextView = itemView.findViewById(R.id.tv_time)
        val tvCurrentPoint:TextView = itemView.findViewById(R.id.current_point)
        val tvAddPoint:TextView = itemView.findViewById(R.id.add_point)
    }
}