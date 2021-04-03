package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.Window
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.example.kotlindemo.MainActivity
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.sharedElementEnterTransition = ChangeBounds()
            window.sharedElementExitTransition = ChangeBounds()
        }
        super.onCreate(savedInstanceState)

        if (!isTaskRoot()) {
            var intent: Intent = getIntent()
            var action: String? = intent.action
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action == Intent.ACTION_MAIN) {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
                return
            }
        }

        setContentView(R.layout.activity_splash)
        var sceneRoot = findViewById<FrameLayout>(R.id.fl_show)
        // 创建Scene
        val scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this)
        //自动切换页面
        goToSubmit(scene1, scene2)
        bt_start.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


    /**
     * 自动切换输入页面
     */

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun goToSubmit(scene1: Scene, scene2: Scene) {

        val transition =
                TransitionInflater.from(this).inflateTransition(R.transition.slide_transition)
        TransitionManager.go(scene1, transition)


        Handler().postDelayed(Runnable() {
            val transition =
                    TransitionInflater.from(this).inflateTransition(R.transition.slide_transition)
            TransitionManager.go(scene2, transition)
        }, 3000)// 延时3秒

    }
}


