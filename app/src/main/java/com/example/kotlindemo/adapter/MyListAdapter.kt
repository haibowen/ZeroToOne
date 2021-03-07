package com.example.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.News

class MyListAdapter(var bean: List<News>, var context: Context?) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_show, parent, false))

    }

    override fun getItemCount(): Int {


        return if (null == bean) 0 else bean.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imageShow.setImageResource(R.drawable.ic_launcher_foreground)
        holder.tvShow.text = bean[position].name


    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var imageShow: ImageView = view.findViewById(R.id.iv_show)
        var tvShow: TextView = view.findViewById(R.id.tv_show)
    }


}