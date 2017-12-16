package com.jdboy.fsutils.fsutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

    /**
     * 输入流写入输出流后关闭
     * @param inputStream
     * @param outputFile
     * @throws IOException
     */
    public void inputStream2outputStream(InputStream inputStream,OutputStream outputFile) throws IOException {
        byte[] bytes=new byte[1024];
        int lenght=0;
        while ((lenght=inputStream.read(bytes))!=-1){
            outputFile.write(bytes,0,lenght);
        }
        outputFile.flush();
        inputStream.close();
        outputFile.close();

    }


}
