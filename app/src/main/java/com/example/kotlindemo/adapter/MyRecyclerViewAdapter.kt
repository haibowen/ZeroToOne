package com.example.kotlindemo.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R

class MyRecyclerViewAdapter(var context: Context, var dateList: List<String>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_beauty_card_time, parent, false))
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.text.text = dateList[position]

        holder.itemView.setOnClickListener {
            Log.e("ada","列表点击了")
        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById(R.id.tv_show_time)
    }
}