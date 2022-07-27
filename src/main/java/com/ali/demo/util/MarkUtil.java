package com.ali.demo.util;

public class MarkUtil {
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
