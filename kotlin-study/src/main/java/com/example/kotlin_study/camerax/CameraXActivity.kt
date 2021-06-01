package com.example.kotlin_study.camerax

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlin_study.R
import kotlinx.android.synthetic.main.activity_camera_x.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraXActivity : AppCompatActivity() {


    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService


    companion object {
        private const val TAG = "CameraX"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_x)
        //申请权限
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        camera_capture_button.setOnClickListener {

            Log.e("test","点击了")
            takePhoto()
        }
        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }


    /**
     * 请求权限
     */
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * 得到输出目录
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.hello_blank_fragment)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    /**
     * 打开camera
     */

    private fun startCamera() {
        val cameraProviderFuture=ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable {
            //相机 绑定 生命周期
            val cameraProvider:ProcessCameraProvider=cameraProviderFuture.get()
            val  preview=Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(view_finder.surfaceProvider)
                    }

            //Select  back camera as default
            val cameraSelector=CameraSelector.DEFAULT_BACK_CAMERA

            try{
                //unbind use cases
                cameraProvider.unbindAll()
                //bind use cases to camera
                cameraProvider.bindToLifecycle(this,cameraSelector,preview)

            }catch (exc:Exception){
                Log.e("Test",exc.toString())

            }
        },ContextCompat.getMainExecutor(this))

    }

    /**
     * 照片
     *
     */
    private fun takePhoto() {

        //get a stable
        val  imageCapture=imageCapture?:return
        val photoFile=File(outputDirectory, SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis())+".jpg")
        val outputOptions=ImageCapture.OutputFileOptions.Builder(photoFile).build()

        imageCapture.takePicture(
                outputOptions,ContextCompat.getMainExecutor(this),object :ImageCapture.OnImageSavedCallback{
            override fun onError(exception: ImageCaptureException) {
                Toast.makeText(this@CameraXActivity,exception.toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                val savedUri=Uri.fromFile(photoFile)
                val msg="photo saved successed $savedUri"
                Toast.makeText(this@CameraXActivity,msg,Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== REQUEST_CODE_PERMISSIONS){
            if (allPermissionsGranted()){
                startCamera()
            }else{
                Toast.makeText(this,"没有授予权限",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}