package cn.yuanfengshan.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流的工具类
 */
public class IOUtil {
    /**
     * 在输入流中读取String内容
     *
     * @param inputStream
     * @return
     */
    public static String getStringByInputStream(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            byte[] bytes = new byte[1024];
            int lenght = 0;
            while ((lenght = inputStream.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, lenght));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 输入流写入输出流后关闭
     *
     * @param inputStream
     * @param outputFile
     * @throws IOException
     */
    public static void inputStream2outputStream(InputStream inputStream, OutputStream outputFile) {
        byte[] bytes = new byte[1024];
        int lenght = -1;
        try {
            while ((lenght = inputStream.read(bytes)) != -1) {
                outputFile.write(bytes, 0, lenght);
            }
            outputFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
