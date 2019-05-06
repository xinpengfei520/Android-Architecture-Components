package com.xpf.arch_component.utils;

import java.util.Random;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
public class RandomUtil {

    public static String getRandomNumber() {
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(num);
    }

    public static String getRandomName(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomPhone() {
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        return "13800" + num;
    }
}
