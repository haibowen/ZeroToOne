package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_articial.*

class ArterialActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articial)

        var view: View
        var intent: Intent = getIntent()
        var url = intent.getStringExtra("url")

        wb_show_something.loadUrl(url.toString())
        wb_show_something.webViewClient = WebViewClient()
    }
}