package com.example.kotlindemo.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlindemo.`interface`.GithubService
import com.example.kotlindemo.bean.Repo


class RepoPagingSource(private val githubService: GithubService) : PagingSource<Int, Repo>() {
    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val repoResponse = githubService.searchRepose(page, pageSize)
            val repoItemss = repoResponse.items
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItemss.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItemss, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}