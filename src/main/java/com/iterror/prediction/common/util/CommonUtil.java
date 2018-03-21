package com.iterror.prediction.common.util;

import java.util.Random;

public class CommonUtil {
    private static Random random = new Random();

    public static int getRandomNum(int num) {
        if (num == 0) {
            return 0;
        }
        return random.nextInt(num);
    }
}
