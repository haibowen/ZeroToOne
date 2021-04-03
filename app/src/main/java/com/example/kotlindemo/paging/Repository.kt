package com.example.kotlindemo.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kotlindemo.`interface`.GithubService
import com.example.kotlindemo.bean.Repo
import kotlinx.coroutines.flow.Flow

/**
 * 协程中的flow  跟rxjava 技术类似
 */
object Repository {

    private const val PAGE_SIZE = 50
    private val githubService = GithubService.create()

    fun getPagingData(): Flow<PagingData<Repo>> {
        return Pager(
                config = PagingConfig(PAGE_SIZE),
                pagingSourceFactory = {
                    RepoPagingSource(githubService)
                }
        ).flow
    }
}