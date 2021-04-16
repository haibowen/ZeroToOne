package com.example.kotlindemo.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_cons_2.view.*

class CosLayoutView2(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context,attrs) {

    init {
        View.inflate(context, R.layout.activity_cons_3, this)
    }
}