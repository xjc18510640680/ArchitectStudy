package com.xjc.study.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: TODO
 *
 * @title: HashMap
 * Created by 19040838 on 2021.02.04 14:54
 */
public class HashMapTest {
    public static void main(String[] args) {
        String str = "a";
        String str1 = new String("a");
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
    }
}
