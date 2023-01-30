package cn.yuanfengshan.common.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

/**
 * 设备信息工具类
 */
public class DeviceUtil {
    public static final String TAG = "YFS";

    public static String getIMEI(Context context) {
        String deviceId = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //需要权限
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "getIMEI: 没有权限");
            } else {
                Log.d(TAG, "getIMEI: 有权限");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                deviceId = telephonyManager.getDeviceId();
                return deviceId;
            }
        } else {
            //不需要动态权限
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = telephonyManager.getDeviceId();
        }
        return deviceId;
    }
}
