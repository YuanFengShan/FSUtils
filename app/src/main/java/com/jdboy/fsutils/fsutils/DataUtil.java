package com.jdboy.fsutils.fsutils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 只是简单记录下格式化当前系统时间的年月日小时分钟秒的标识
 * Created by 64563 on 2017/12/11.
 */
public class DataUtil {
    private DataUtil() {

    }

    private static class Helper {
        private static DataUtil intance = new DataUtil();
    }

    public static DataUtil getIntnace() {
        return Helper.intance;
    }

    /**
     * 获取当前时间
     *
     * @param context
     * @return
     */
    public String getCurrentData(Context context) {
        long l = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date(l);//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
