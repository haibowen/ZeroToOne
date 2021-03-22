package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kotlindemo.R
import com.example.kotlindemo.permission.PermissionUtils
import com.example.kotlindemo.permission.PermissionUtils.PermissionRequestListener

class FirstActivity : BaseActivity() {

    private val button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<View>(R.id.bt_show).setOnClickListener { startActivity(Intent(this@FirstActivity, BehaviorActivity::class.java)) }


        val permissionUtils = PermissionUtils(this)
        permissionUtils.requestPermission(this, "", object : PermissionRequestListener {
            override fun onFirstRequestPermission() {}
            override fun onPermissionPreviouslyDenied() {}
            override fun onPermissionPreviouslyDeniedWithNeverAskAgain() {}
            override fun onPermissionGranted() {}
        })

    }
}