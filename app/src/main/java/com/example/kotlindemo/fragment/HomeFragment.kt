package com.example.kotlindemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.MyListAdapter
import com.example.kotlindemo.bean.ArticalData
import com.example.kotlindemo.bean.News
import com.example.kotlindemo.net.NetWorkManager
import com.example.kotlindemo.net.response.ResponseData
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import java.util.*


class HomeFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var arrayList: MutableList<ArticalData.AuthorData> = ArrayList()
    private var myListAdapter: MyListAdapter? = null
    private var toolbar: Toolbar? = null
    private var mCollapsingToolbarLayout: CollapsingToolbarLayout? = null
    var page:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //设置 toolbar
        toolbar = view?.findViewById<Toolbar>(R.id.tool_bar_show)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        var actionBar: androidx.appcompat.app.ActionBar? = (activity as AppCompatActivity?)!!.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        } else {
            mCollapsingToolbarLayout?.isTitleEnabled = true

        }
        //设置上拉刷新下拉加载
        setRefreshLayout(view)
        //获取数据
        getData(page)


    }

    /**
     * s设置上拉刷新下来加载
     */

    private fun setRefreshLayout(view: View) {


        var refreshLayout: SmartRefreshLayout = view?.findViewById(R.id.refreshLayout)//id 绑定
        refreshLayout.setRefreshHeader(ClassicsHeader(context))//设置头部
        refreshLayout.setRefreshFooter(ClassicsFooter(context))//设置底部

        //刷新的回调
        refreshLayout.setOnRefreshListener { refreshLayout ->
            getData(page)
            refreshLayout.finishRefresh(2000 /*,false*/) //传入false表示刷新失败
        }
        //加载更多的回调
        refreshLayout.setOnLoadMoreListener { refreshLayout ->
            page++
            getData(page)
            refreshLayout.finishLoadMore(2000 /*,false*/) //传入false表示加载失败
        }


    }


    /**
     * mock 网络数据
     */
    private fun getData( page:Int) {

        NetWorkManager.request?.getAllArticle(page)?.enqueue(object : Callback<ResponseData<ArticalData>> {
            override fun onResponse(call: Call<ResponseData<ArticalData>>, response: retrofit2.Response<ResponseData<ArticalData>>) {
                var bean: List<ArticalData.AuthorData>? = response.body()?.data?.datas
                if (bean != null) {
                    handleData(bean)
                    Log.e("onResponse", bean[0].author + "")
                }
            }

            override fun onFailure(call: Call<ResponseData<ArticalData>>, t: Throwable) {
                Log.e("onFailure", t.toString())
            }
        })
    }

    /**
     * 处理数据 展示数据
     */
    private fun handleData( bean:List<ArticalData.AuthorData>) {
        recyclerView = view?.findViewById(R.id.rv_show_list)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = linearLayoutManager
        myListAdapter = MyListAdapter(bean, context)
        recyclerView?.adapter = myListAdapter
    }

}