package cn.yuanfengshan.common.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import dalvik.system.DexClassLoader;

public class DexLoaderUtil {
    private static final String TAG = "xposed";

    public static DexClassLoader loaderDexForSDCardDexFile(Context context, String sdcardDexFilePath) {
        Log.d(TAG, "loaderDexForSDCardDexFile: SD卡中的dex文件路径:" + sdcardDexFilePath);
        File sdDexFile = new File(sdcardDexFilePath);
        String name = sdDexFile.getName();
        Log.d(TAG, "loaderDexForSDCardDexFile: 文件名:" + name);
        //判断企业微信中是否已存在dex文件
        File appDexFile = context.getFileStreamPath(name);
//        if (!appDexFile.exists()) {
        if (!sdDexFile.exists()) {
            Log.d(TAG, "loaderDexForSDCardDexFile: 文件不存在,无法加载!!!");
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(sdDexFile);
            FileOutputStream fileOutputStream = new FileOutputStream(appDexFile);
            IOUtil.inputStream2outputStream(fileInputStream, fileOutputStream);
        } catch (FileNotFoundException e) {
            Log.d(TAG, "loaderDexForSDCardDexFile: 加载失败");
            e.printStackTrace();
            return null;
        }
        Log.d(TAG, "loaderDexForSDCardDexFile: 复制dex文件完成");
//        }
        String loaderDexPath = appDexFile.getPath();
        Log.d(TAG, "loaderDexForSDCardDexFile: dex文件在私有目录的地址:" + loaderDexPath);
        File releaseDexDirFile = context.getDir("dex", 0);
        String releaseDexDir = releaseDexDirFile.getAbsolutePath();
        Log.d(TAG, "loaderDexForSDCardDexFile: 安装dex目录:" + releaseDexDir);
        DexClassLoader dexClassLoader = new DexClassLoader(loaderDexPath, releaseDexDir, null, context.getClassLoader());
        return dexClassLoader;
    }


}
