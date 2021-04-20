package com.example.kotlindemo.activity

import android.Manifest
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
import com.example.kotlindemo.view.dialog.AnotherDialog
import com.example.kotlindemo.view.dialog.CustomerDialog
import com.example.kotlindemo.view.dialog.CustomerFragmentDialog
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import com.tencent.mmkv.MMKV
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import kotlinx.android.synthetic.main.activity_main2.*

class FirstActivity : BaseActivity() {

    private val button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<View>(R.id.bt_show).setOnClickListener { startActivity(Intent(this@FirstActivity, BehaviorActivity::class.java)) }


        val permissionUtils = PermissionUtils(this)
        permissionUtils.requestPermission(this, Manifest.permission.CAMERA, object : PermissionRequestListener {
            override fun onFirstRequestPermission() {}
            override fun onPermissionPreviouslyDenied() {}
            override fun onPermissionPreviouslyDeniedWithNeverAskAgain() {}
            override fun onPermissionGranted() {}
        })

        bt_home_third.setOnClickListener {
            startActivity(Intent(this, Paging3Activity::class.java))
        }
        bt_home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        bt_home_four.setOnClickListener {

            val customerFragmentDialog: CustomerFragmentDialog = CustomerFragmentDialog()
            customerFragmentDialog.show(supportFragmentManager, "")

        }
        bt_home_five.setOnClickListener {
            startActivity(Intent(this, ConsActivity::class.java))
        }
        bt_home_six.setOnClickListener {
            val kv: MMKV = MMKV.defaultMMKV()!!
            kv.encode("int", Integer.MIN_VALUE)
            Toast.makeText(this, kv.decodeInt("int").toString(), Toast.LENGTH_SHORT).show()
        }

        bt_home_seven.setOnClickListener {

            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        bt_home_eight.setOnClickListener {
            startActivity(Intent(this, FloatActivity::class.java))
        }
        bt_home_nine.setOnClickListener {

            var hashMap = HashMap<String, String>()
//            FlutterBoost.instance().open("second_page", hashMap as Map<String, Any>?);
            val intent = FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity::class.java, FlutterBoost.ENGINE_ID)
                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque)
                    .destroyEngineWithActivity(false)
                    .url("second_page")
                    .urlParams(hashMap as Map<String, Any>?)
                    .build(this)
            startActivity(intent)
        }

        bt_home_ten.setOnClickListener {
            startActivity(Intent(this, ViewPager2Activity::class.java))

        }

        bt_home_ele.setOnClickListener {

            var dialog = CustomerDialog(this)
            dialog.show()
        }

        bt_home_twl.setOnClickListener {
            var dialog=AnotherDialog(this)
            dialog.show()

        }
        bt_home_13.setOnClickListener {

            startActivity(Intent(this,ListActivity::class.java))
        }

        bt_home_14.setOnClickListener {
            startActivity(Intent(this,ListMoreActivity::class.java))
        }


    }
}