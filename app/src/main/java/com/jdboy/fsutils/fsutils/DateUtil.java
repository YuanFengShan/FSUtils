package com.jdboy.fsutils.fsutils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 只是简单记录下格式化当前系统时间的年月日小时分钟秒的标识
 * Created by 64563 on 2017/12/11.
 */
public class DateUtil {
    private DateUtil() {

    }

    private static class Helper {
        private static DateUtil intance = new DateUtil();
    }

    public static DateUtil getIntnace() {
        return Helper.intance;
    }

    /**
     * 获取当前时间
     *
     * @return 返回样例(2017年12月16日 17时28分45秒)
     */
    public String getCurrentDate() {
        long l = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date curDate = new Date(l);//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    public static void main(String[] args) {
        String currentDate = DateUtil.getIntnace().getCurrentDate();
        System.out.println("当前时间:" + currentDate);
    }
}
