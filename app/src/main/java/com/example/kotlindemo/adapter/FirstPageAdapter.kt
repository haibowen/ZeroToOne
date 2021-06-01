package com.example.kotlindemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.FirstPageBean

/**
 * Created on 4/19/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class FirstPageAdapter(var context: Context, var list: MutableList<FirstPageBean>) : RecyclerView.Adapter<FirstPageAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.text.text=list[position].string
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,list[position].cls))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_card_show, parent, false)
        var viewHolder: MyViewHolder = MyViewHolder(view)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById(R.id.tv_show_item)
    }
}