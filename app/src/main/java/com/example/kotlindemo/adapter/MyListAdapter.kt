package com.example.kotlindemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.activity.ArticialActivity
import com.example.kotlindemo.bean.ArticalData
import com.example.kotlindemo.bean.News

class MyListAdapter(var bean: List<ArticalData.AuthorData>, var context: Context?) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_show, parent, false))

    }

    override fun getItemCount(): Int {


        return if (null == bean) 0 else bean.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTime.text=bean[position].niceDate
        holder.tvTitle.text=bean[position].title
        holder.tvType.text="分类:"+bean[position].chapterName
        holder.tvAuthor.text="作者:"+bean[position].author

        holder.itemView.setOnClickListener {

            var intent:Intent= Intent(context,ArticialActivity::class.java)
            intent.putExtra("url",bean[position].link)
            context?.startActivity(intent)
        }


    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var tvAuthor: TextView = view.findViewById(R.id.tv_author)
        var tvTitle:TextView=view.findViewById(R.id.tv_title)
        var tvTime:TextView=view.findViewById(R.id.tv_time)
        var tvType:TextView=view.findViewById(R.id.tv_type)

    }


}