package com.example.tradixapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradixapp.R
import com.example.tradixapp.User

class UserAdapter(var context: Context?,var listUser:ArrayList<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var onClick:((Int)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    fun setCallBack(callBack : (Int)->Unit) {
        onClick = callBack
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = listUser[position]
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
        if (listUser!=null){
            return listUser.size
        }
        return 0
    }
    fun removeItem(viewHolder: RecyclerView.ViewHolder){
        listUser.removeAt(viewHolder.adapterPosition)
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