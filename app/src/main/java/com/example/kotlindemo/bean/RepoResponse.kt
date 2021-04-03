package com.example.kotlindemo.bean

import com.google.gson.annotations.SerializedName

/**
 * 以集合的形式包裹数据类
 */
class RepoResponse (
        @SerializedName("items")val items:List<Repo> = emptyList()

)