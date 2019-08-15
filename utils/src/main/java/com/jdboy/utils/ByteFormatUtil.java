package com.jdboy.utils;

import android.util.Log;


public class ByteFormatUtil {
    private static final String TAG = "ByteFormatUtil";

    public static void main(String[] args) {
//        byte[] bytes = "测试".getBytes("utf-8");
//        System.out.println("10进制的byte:" + Arrays.toString(bytes));
//        System.out.println("10进制转换成String:" + new String(bytes));
//        String format = bytesToHexString(bytes);
        String format = "[E6,B5,8B,E8,AF,95]";
        System.out.println("16进制字符串:" + format);
        String s = null;
        try {
            s = hexToString(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("16进制转换后的String:" + s);
    }

    public static String hexToString(String format) throws Exception {
        return new String(hexStringToByte(format), "utf-8");
    }

    /**
     * 16进制的byte字符串转换为正常的byte[]
     * @param hexByteString
     * @return
     * @throws Exception
     */
    public static byte[] hexStringToByte(String hexByteString) throws Exception {
        int length1 = hexByteString.length();
        int flag = length1 % 2;
        if (flag != 0) {
            throw new Exception("字节码长度必须为2的倍数");
        }
        int byteLength = length1 / 2;
        Log.d(TAG, "数据的长度: " + byteLength);
        String[] split = new String[byteLength];

        for (int i = 0; i < byteLength; i++) {
            int indexStart = i * 2;
            char c = hexByteString.charAt(indexStart);
            char c1 = hexByteString.charAt(indexStart + 1);
            split[i] = String.valueOf(c) + String.valueOf(c1);
        }
//        String[] split = hexByteString.replace("[", "").replace("]", "").split(",");
        byte[] newBytes = new byte[byteLength];
        for (int i = 0; i < byteLength; i++) {
            try {
                byte bytes1 = hexToByte(split[i]);
//                System.out.println("单个值:" + bytes1);
                newBytes[i] = bytes1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newBytes;
    }


    /**
     * 将byte[] 转换为16进制的字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        int length = bytes.length;
        StringBuffer stringBuffer = new StringBuffer();
        byte aByte = bytes[0];
        stringBuffer.append(byteToHex(aByte));
        for (int i = 1; i < length; i++) {
            byte aByte2 = bytes[i];
            stringBuffer.append(byteToHex(aByte2));
        }
        return stringBuffer.toString().toUpperCase();
    }


    private static byte hexToByte(String hexString) throws Exception {
        return (byte) Integer.parseInt(hexString, 16);

    }


    /**
     * 字节转十六进制
     *
     * @param b 需要进行转换的byte字节
     * @return 转换后的Hex字符串
     */
    private static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }
}
