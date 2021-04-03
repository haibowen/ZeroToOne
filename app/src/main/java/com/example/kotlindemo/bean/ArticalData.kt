package com.example.kotlindemo.bean




data class ArticalData(var curPage: Int, var offset: Int, var datas: List<AuthorData>, var pageCount: Int,
                       var size: Int,var total:Int


) {

    data class  AuthorData(var author:String,var link:String,var niceDate:String,var chapterName:String,var title:String,var envelopePic:String)
}


