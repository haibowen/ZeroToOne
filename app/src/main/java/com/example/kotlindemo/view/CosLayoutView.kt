package com.example.kotlindemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlindemo.R

class CosLayoutView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context,attrs) {

    init {
        View.inflate(context, R.layout.activity_cons_2, this)
    }
}