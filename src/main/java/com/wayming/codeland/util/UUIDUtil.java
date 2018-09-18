package com.wayming.codeland.util;

import org.springframework.util.DigestUtils;

import java.time.Instant;
import java.util.UUID;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午4:25
 */
public class UUIDUtil {
    /**
     * 盐值
     */
    private static final String salt = "kh~!@~asdk4k186:21//\\124（（４";

    /**
     *获取API UUID
     * @return
     */
    public static String createByAPI() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     *获取当前时间数字字符串
     * @return
     */
    public static String createByTime() {
        StringBuilder nowTime = new StringBuilder(String.valueOf(Instant.now().getEpochSecond()));
        for (int i = 0; i < 5; i++) {
            nowTime.append((int)(Math.random()*9));
        }
        return nowTime.toString();
    }

    /**
     * 获取MD5
     * @param string
     * @return
     */
    public static String createMD5(String string) {
        string = salt + string;
        return DigestUtils.md5DigestAsHex(string.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(createByAPI());
        System.out.println(createByTime());
        System.out.println(createMD5("123"));
    }

}
