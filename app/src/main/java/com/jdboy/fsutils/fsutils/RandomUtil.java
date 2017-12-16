package com.jdboy.fsutils.fsutils;

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
        return new Random().nextInt(max) % (max - min) + min;
    }

//小测试
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int i1 = nextInt(10, 20);
            System.out.println("随机数:" + i1);
        }
    }


}
