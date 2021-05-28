package com.xjc.study.test;

import com.xjc.study.toolutils.IntegerUtils;

/**
 * @description:
 * @author: xujiucheng
 * @date: 2021/5/25 10:05 
 */
public class Test {

    private static final double MAX = 10000.00;

    public static void main(String[] args) {
        System.out.println(0.65*40000);
        double a = IntegerUtils.nextDouble(1000.00,5000.00);
        double b = IntegerUtils.nextDouble(1000.00,5000.00 - a);
        double c = IntegerUtils.nextDouble(1000.00,5000.00 - (a - b));
        double d = IntegerUtils.nextDouble(1000.00,5000.00 - (a - b -c));
        double e = IntegerUtils.nextDouble(1000.00,5000.00 - (a - b - c - d));
        if (a + b + c + d + e <= MAX) {
            System.out.println(a + b + c + d + e);
            System.out.println(a + "===" + b + "===" + c + "===" + d + "===" + e);
        }
    }

    /**
     * @description:
     * @author: xujiucheng
     * @date: 2021/5/25 14:16 
     * @param:  * @param null
     * @exception:
     * @return: {@link null} 
     */
    public String test(String str) {
        return null;
    }
}
