package com.example.kotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.RepoAdapter
import com.example.kotlindemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_paging3.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Paging3Activity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val repoAdapter=RepoAdapter()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging3)

        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.adapter=repoAdapter

        lifecycleScope.launch {
            viewModel.getPagingData().collect {
                pagingData->
                repoAdapter.submitData(pagingData)
            }
        }

        repoAdapter.addLoadStateListener {

            when(it.refresh){
                is LoadState.NotLoading->{
                    progress_bar.visibility= View.INVISIBLE
                    recycler_view.visibility=View.VISIBLE

                }
                is LoadState.Loading->{
                    progress_bar.visibility=View.VISIBLE
                    recycler_view.visibility=View.INVISIBLE
                }

                is LoadState.Error->{
                    val state=it.refresh as LoadState.Error
                    progress_bar.visibility=View.INVISIBLE
                    Toast.makeText(this,"Load Error:${state.error.message}",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}