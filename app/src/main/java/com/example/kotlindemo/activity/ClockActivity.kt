package com.example.kotlindemo.activity

import android.app.Service
import android.os.Bundle
import android.os.Vibrator
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_clock.*

class ClockActivity : AppCompatActivity() {

    var myVibrator:Vibrator?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        // 获得系统的Vibrator实例
        myVibrator = getSystemService(Service.VIBRATOR_SERVICE) as Vibrator

        flash_line.setOnTouchListener(OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(this,"，到底是怎样的人对触电毫无知觉呢？？？",Toast.LENGTH_SHORT).show()
                    myVibrator!!.vibrate(longArrayOf(100, 200, 100, 200), 0)
                }
                MotionEvent.ACTION_MOVE->{
                    myVibrator!!.vibrate(longArrayOf(100, 200, 100, 200), 0)
                }
                MotionEvent.ACTION_UP ->{
                    myVibrator?.cancel()
                }
                else->{myVibrator?.cancel()}
            }
            true
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        myVibrator?.cancel()
    }
}