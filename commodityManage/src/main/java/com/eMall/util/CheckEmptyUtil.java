package com.eMall.util;

public final class CheckEmptyUtil {
    public CheckEmptyUtil() {
    }

    public static boolean checkString(String str){
        str = str.trim();
        if ("".equals(str)){
            return false;
        }
        return true;
    }
}
