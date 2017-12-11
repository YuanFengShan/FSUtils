package com.jdboy.fsutils.fsutils;

/**
 * 所有工具类的入口
 * Created by 64563 on 2017/11/13.
 */
public class FsUtils {
    private FsUtils() {

    }

    static class Helper {
        static FsUtils instance = new FsUtils();
    }

    public static FsUtils getInstance() {
        return Helper.instance;
    }

    public IOUtil getIoUtil() {
        return IOUtil.getInstance();
    }

    public ShellUtil getShellUtil() {
        return ShellUtil.getInstance();
    }

}
