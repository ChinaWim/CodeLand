package com.wayming.codeland.util;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午4:03
 */
public class StringUtil {

    /**
     *判断是否非空
     * @param string
     * @return
     */
    public static boolean isNotBlank(String string){
        return string != null && ! "".equals(string);
    }

    /**
     *判断是否非空
     * @param strings　
     * @return
     */
    public static boolean isNotBlank(String ... strings){
        for (int i = 0; i < strings.length; i++) {
            if (!isNotBlank(strings[i])){
                return false;
            }
        }
        return true;
    }

}
