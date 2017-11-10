package com.jdboy.fsutils.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO流的工具类
 * Created by 64563 on 2017/11/10.
 */
public class IOUtil {
    private IOUtil() {

    }

    static class helper {
        static IOUtil ioUtil = new IOUtil();
    }

    public static IOUtil getInstance() {
        return helper.ioUtil;
    }

    /**
     * 读取InputStream返回String
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public String getStringByInputStream(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = new byte[1024];
        int lenght = 0;
        while ((lenght = inputStream.read(bytes)) != -1) {
            stringBuffer.append(new String(bytes, 0, lenght));
        }
        inputStream.close();
        return stringBuffer.toString();
    }
}
