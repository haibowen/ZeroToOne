package com.example.kotlindemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.kotlindemo.MainActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.permission.PermissionUtils
import com.example.kotlindemo.permission.PermissionUtils.PermissionRequestListener
import com.example.kotlindemo.service.MyService
import com.example.kotlindemo.view.dialog.CustomerFragmentDialog
import com.tencent.mmkv.MMKV
import kotlinx.android.synthetic.main.activity_main2.*

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

        bt_home_third.setOnClickListener {
            startActivity(Intent(this,Paging3Activity::class.java))
        }
        bt_home.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        bt_home_four.setOnClickListener {

         val customerFragmentDialog: CustomerFragmentDialog = CustomerFragmentDialog()
            customerFragmentDialog.show(supportFragmentManager,"")

        }
        bt_home_five.setOnClickListener {
            startActivity(Intent(this,ConsActivity::class.java))
        }
        bt_home_six.setOnClickListener {
            val  kv:MMKV= MMKV.defaultMMKV()!!
            kv.encode("int",Integer.MIN_VALUE)
            Toast.makeText(this,kv.decodeInt("int").toString(),Toast.LENGTH_SHORT).show()
        }

        bt_home_seven.setOnClickListener {

         val  intent= Intent(this,MyService::class.java)
            startService(intent)
        }

    }
}