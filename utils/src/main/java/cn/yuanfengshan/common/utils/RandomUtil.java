package cn.yuanfengshan.common.utils;

import java.util.Date;
import java.util.Random;

/**
 * 随机数工具类
 * Created by 64563 on 2017/12/16.
 */
public class RandomUtil {
    /**
     * 获取指定范围int值的随机数
     *
     * @param min 最小值(包含)
     * @param max 最大值(不包含)
     * @return
     */
    public static int nextInt(int min, int max) {
        if (min == max) {
            return min;
        }
        if (min > max) {
            return min;
        }
        return new Random().nextInt(max) % (max - min) + min;
    }

    /**
     * 随机16进制的数字
     *
     * @param max 需要获取几位的数字
     * @return
     */
    public static String get16Hexadecimal(int max) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < max; i++) {
            int i1 = nextInt(0, 15);
            String s = Integer.toHexString(i1);
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    private static String[] StringList = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static String[] StringList2 = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private static String[] StringList3 = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    /**
     * 获取指定长度的字符串
     *
     * @param lenght
     * @return
     */
    public static String getRandomString(int lenght) {
        int tableLenght = StringList.length;
        int tableLenght2 = StringList2.length;
        int tableLenght3 = StringList3.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lenght; i++) {
            if (i == 0) {
                stringBuffer.append(StringList[nextInt(0, tableLenght)]);
            } else {
                stringBuffer.append(StringList3[nextInt(0, tableLenght3)]);
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        double tmp= 3L / 100D ;
        System.out.println("args = [" + tmp + "]");
    }

    public static float nextFloat(int min, int max) {
        float result = 0;
        if (min < 0) {
            //带负数
            int nextInt = nextInt(0, 100);
            if (nextInt >= 50) {
                //正数
                result = nextInt(0, max) + new Random().nextFloat();
            } else {
                //负数
                result = 0 - nextInt(0, max) + 0 - new Random().nextFloat();

            }
        } else {
            //只考虑正数
            result = nextInt(0, max) + new Random().nextFloat();
        }
        return result;
    }

    public static String getStringRandom() {
        Random mRandom = new Random(new Date().getTime());
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = new StringBuilder(String.valueOf(str)).append(Integer.toHexString(Byte.valueOf((byte) mRandom.nextInt(17)).byteValue() & 15)).toString();
        }
        return str;
    }

}
