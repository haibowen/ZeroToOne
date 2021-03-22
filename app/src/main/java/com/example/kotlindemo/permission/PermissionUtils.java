package com.example.kotlindemo.permission;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.core.app.ActivityCompat;

/**
 * 申请权限的封装
 */

public class PermissionUtils {

    private String ReQuestName="My_request";
    private Context mContext;

    public PermissionUtils(Context context) {
        mContext = context;
    }

    public void  requestPermission(Context context, String permission, PermissionRequestListener permissionRequestListener){
        if (shouldAskPermission()){
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,permission)){
                permissionRequestListener.onPermissionPreviouslyDenied();
            }else {
                if (isFirstTimeAsking(permission,context)){
                    firstTimeAsking(permission,false,context);
                    permissionRequestListener.onFirstRequestPermission();
                }else {
                    permissionRequestListener.onPermissionPreviouslyDeniedWithNeverAskAgain();
                }
            }
        }else {
            permissionRequestListener.onPermissionGranted();
        }
    }

    /**
     * 判断版本
     * 23 以及以上需要申请权限
     */
    public boolean shouldAskPermission(){
        return (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M);
    }

    /**
     * 储存申请 权限
     */

    public void firstTimeAsking(String permission,boolean isFirstTime,Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(ReQuestName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(permission,isFirstTime);
        editor.commit();

    }

    /**
     * 是否是第一次申请
     */

    public boolean isFirstTimeAsking(String permission,Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(ReQuestName,Context.MODE_PRIVATE);
        return  sharedPreferences.getBoolean(permission,true);

    }

    /**
     * 提供的暴露接口
     */
    public interface PermissionRequestListener{

        //第一次申请
        void onFirstRequestPermission();
        //用户拒绝权限申请，但是没有选中  不再提示的选项
        void onPermissionPreviouslyDenied();
        //用户拒绝权限申请，并选中不再提示 选项
        void onPermissionPreviouslyDeniedWithNeverAskAgain();
        //权限已获取
        void onPermissionGranted();

    }
}
