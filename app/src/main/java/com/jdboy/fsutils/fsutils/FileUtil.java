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

    /**
     * 复制文件
     *
     * @param indexFile
     * @param copyFile
     * @throws IOException
     */
    public void copyFile(File indexFile, File copyFile) throws IOException {
        if (!indexFile.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream fileInputStream = new FileInputStream(indexFile);
        FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
        IOUtil.getInstance().inputStream2outputStream(fileInputStream, fileOutputStream);
    }

    /**
     * 使用BufferedReader来读取文件的内容
     *
     * @param filePath 被读取文件的路径
     * @return
     * @throws IOException
     */
    public String readFileContent(String filePath) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //存放读取出来的每行的内容
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            //可选择性是否换行符
            stringBuffer.append("\r\n");
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }
}
