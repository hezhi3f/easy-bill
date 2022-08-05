package com.hezhi3f.easybill.util;

import java.util.Random;
import java.util.UUID;

public class CodeUtils {
    private static final Random R = new Random();

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String code6() {
        return String.valueOf(R.nextInt(900000) + 100000);
    }
}
