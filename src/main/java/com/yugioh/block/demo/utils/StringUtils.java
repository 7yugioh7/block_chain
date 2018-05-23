package com.yugioh.block.demo.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author Create By lieber
 * @Description
 * @Date Create in 2018/5/23 10:37
 * @Modify By
 */
@Component
public class StringUtils {

    /**
     * 随机字符串包含的所有字符数组
     */
    private final static char[] CHARS = "befOPQRSTcdzABrsWXYaZ012tuvwV34xyGHIghiEFU567jklmnopqJKLMNCD89".toCharArray();

    /**
     * 生成随机字符串
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public String generateRandomString(int length) {
        //随机类初始化
        Random random = new Random();
        //StringBuffer类生成，为了拼接字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(CHARS.length);
            sb.append(CHARS[number]);
        }
        return sb.toString();
    }

}
