package com.example.kotlindemo.activity

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_view.*


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)


        iv_show_right.setOnClickListener {
            Log.e("ViewActivity", "图片点击了")
            shotActivity(this)

        }
        tv_show.setOnClickListener {
            Log.e("ViewActivity", "底层的点击了")
            var bitmapDrawable = BitmapDrawable(shotActivity(this))
            iv_screen_show.setImageDrawable(bitmapDrawable)
        }
    }

    /**
     * 截屏的操作
     */

    fun shotActivity(activity: Activity): Bitmap {
        // 获取windows中最顶层的view
        // 获取windows中最顶层的view
        val view: View = activity.getWindow().getDecorView()
        view.buildDrawingCache()

        // 获取状态栏高度

        // 获取状态栏高度
        val rect = Rect()
        view.getWindowVisibleDisplayFrame(rect)
        val statusBarHeights: Int = rect.top
        val display: Display = activity.getWindowManager().getDefaultDisplay()

        // 获取屏幕宽和高

        // 获取屏幕宽和高
        val widths = display.width
        val heights = display.height

        // 允许当前窗口保存缓存信息

        // 允许当前窗口保存缓存信息
        view.isDrawingCacheEnabled = true

        // 去掉状态栏

        // 去掉状态栏
        val bmp = Bitmap.createBitmap(view.drawingCache, 0,
                statusBarHeights, widths, heights - statusBarHeights)

        // 销毁缓存信息

        // 销毁缓存信息
        view.destroyDrawingCache()

        return bmp
    }
}