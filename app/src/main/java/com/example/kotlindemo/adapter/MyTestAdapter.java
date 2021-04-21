package com.example.kotlindemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlindemo.R;

import java.util.List;

/**
 * Created on 4/19/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.MyViewHolder> {

    public Context mContext;

    private List<String> dataList;

    private int defaultItem;

    public MyTestAdapter(Context context, List<String> beans) {
        mContext = context;
        dataList = beans;
    }

    /**
     * 更新位置
     * @param
     * @param
     * @return
     */

    public void setDefaultItem(int position){
        this.defaultItem=position;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyTestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_show_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTestAdapter.MyViewHolder holder, int position) {

        holder.textView.setText(dataList.get(position));

        if (defaultItem!=-1){
            if (defaultItem==position){
                holder.textView.setTextColor(Color.RED);
            }else {
                holder.textView.setTextColor(Color.BLACK);
            }
        }


    }

    /**
     *
     * @return
     */

    public List<String> getDataList(){

        return dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_show);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickBack!=null){

                        mClickBack.clickListner(dataList.get(getLayoutPosition()),getLayoutPosition());
                    }

                }
            });

        }
    }

    public interface ClickBack {

        void clickListner(String name, int position);
    }

    public ClickBack mClickBack;

    public void setOnclikClick(ClickBack click) {
        mClickBack = click;

    }
}
