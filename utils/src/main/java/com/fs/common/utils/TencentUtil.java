package com.fs.common.utils;

/**
 * 专门给腾讯用的工具类
 */
public class TencentUtil {
    /**
     * 获取数据库的秘钥
     *
     * @param uin
     * @param imei
     * @return
     */
    public static String getDatabasePassword(String uin, String imei) {
        String substring = MD5Util.md5(imei + uin).substring(0, 7);
        String s = substring.toLowerCase();
        return s;
    }
}
