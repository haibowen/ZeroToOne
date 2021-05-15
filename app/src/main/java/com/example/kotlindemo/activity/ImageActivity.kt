package com.example.kotlindemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        Glide.with(this).load("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg").apply(RequestOptions.bitmapTransform( RoundedCorners(40))).into(iv_show_one)
    }
}