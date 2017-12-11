package com.jdboy.fsutils.fsutils;

import android.content.res.Resources;

import java.io.*;

/**
 * 文件工具类
 * Created by 64563 on 2017/11/20.
 */
public class FileUtil {
    private FileUtil() {

    }

    private static class Helper {
        private static FileUtil intnace = new FileUtil();
    }

    public static FileUtil getIntnace() {
        return Helper.intnace;
    }

    public void copyFile(File indexFile, File copyFile) throws IOException {
        if (!indexFile.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream fileInputStream = new FileInputStream(indexFile);
        FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
        IOUtil.getInstance().inputStream2outputStream(fileInputStream, fileOutputStream);
    }
}
