package com.jdboy.fsutils.fsutils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 指令shell命令的工具类
 * Created by 64563 on 2017/11/13.
 */
public class ShellUtil {
    private ShellUtil() {

    }

    static class Helper {
        static ShellUtil intance = new ShellUtil();
    }

    public static ShellUtil getInstance() {
        return Helper.intance;
    }

    public String exec(String cmdString) throws IOException {
        Process exec = Runtime.getRuntime().exec(cmdString);
        InputStream inputStream = exec.getInputStream();
        String stringByInputStream = IOUtil.getInstance().getStringByInputStream(inputStream);
        return stringByInputStream;
    }

}
