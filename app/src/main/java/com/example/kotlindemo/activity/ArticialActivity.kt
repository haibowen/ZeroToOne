package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_articial.*

class ArticialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articial)

        var intent: Intent = getIntent()
        var url = intent.getStringExtra("url")

        wb_show_something.loadUrl(url.toString())
        wb_show_something.webViewClient = WebViewClient()
    }
}