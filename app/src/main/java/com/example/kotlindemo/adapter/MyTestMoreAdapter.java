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
import com.example.kotlindemo.bean.CalendarInfor;

import java.util.List;

/**
 * Created on 4/19/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
public class MyTestMoreAdapter extends RecyclerView.Adapter {

    public Context mContext;

    private List<CalendarInfor> dataList;

    private int defaultItem;

    public MyTestMoreAdapter(Context context, List<CalendarInfor> beans) {
        mContext = context;
        dataList = beans;
    }

    /**
     * 更新位置
     *
     * @param
     * @param
     * @return
     */

    public void setDefaultItem(int position) {
        this.defaultItem = position;
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {


        return dataList.get(position).type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case 0:

                View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_show_item_one, parent, false);
                MyViewHolder myViewHolder = new MyViewHolder(view);

                return  myViewHolder;

            case 1:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_list_show_item, parent, false);
                MyViewHolder1 myViewHolder1 = new MyViewHolder1(view1);
                return myViewHolder1;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CalendarInfor calendarInfor = dataList.get(position);
        switch (calendarInfor.type) {

            case 0:
                MyViewHolder myViewHolder=(MyViewHolder) holder;
                myViewHolder.textView.setText(dataList.get(position).content);


                break;

            case 1:
                MyViewHolder1 myViewHolder1=(MyViewHolder1)holder;
                myViewHolder1.textView.setText(dataList.get(position).content);


                if (defaultItem != -1) {
                    if (defaultItem == position) {
                        myViewHolder1.textView.setTextColor(Color.RED);
                    } else {
                        myViewHolder1.textView.setTextColor(Color.BLACK);
                    }
                }

                break;
        }


    }



    /**
     * @return
     */

    public List<CalendarInfor> getDataList() {

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



        }
    }

  class  MyViewHolder1 extends RecyclerView.ViewHolder{

        public TextView textView;


      public MyViewHolder1(@NonNull View itemView) {
          super(itemView);
          textView = itemView.findViewById(R.id.tv_show);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (mClickBack != null) {

                      mClickBack.clickListner(dataList.get(getLayoutPosition()).content, getLayoutPosition());
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
