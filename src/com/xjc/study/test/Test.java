package com.xjc.study.test;

import com.xjc.study.toolutils.ConvertUtils;
import com.xjc.study.toolutils.IntegerUtils;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xujiucheng
 * @date: 2021/5/25 10:05 
 */
public class Test {

    private static final double MAX = 10000.00;

    public static void main(String[] args) {
        test1();
    }

    public static void test() {
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

    public static void test1() {
        Person person = new Person();
        person.setAddress("nanjing");
        person.setAge(29);
        person.setName("xiaoli");
        // bean TO Map
        Map<String, Object> map = ConvertUtils.convertObjToMap(person);
        System.out.println("bean To Map:" + map);
    }
}
