package com.iterror.prediction.common.util;

import java.util.Random;

/**
 * Created by tony.yan on 2018/1/16.
 */
public class CourseUtil {
    /**
     * 检查参数是null,如果参数事String类型，会继续检查String是否为空串
     * @param params
     * @return 都不是null或空串, 返回false, 有一个null或空串 ,返回true
     */

    public static boolean checkParamIsEmpty(Object... params) {
        if (params == null) {
            return true;
        }
        if (params.length == 0) {
            return true;
        }
        for (Object param : params) {
            if (null == param) {
                return true;
            }
            if (param instanceof String) {
                String p = (String)param;
                if (p.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Random random = new Random();

    /**
     *
     * @param num
     * @return
     */
    public static int getRandomNum(int num) {
        if (num == 0) {
            return 0;
        }
        return random.nextInt(num);
    }
}
