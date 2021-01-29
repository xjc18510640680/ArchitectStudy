package com.xjc.study.test.demo.demo20210129;

import java.util.*;

/**
 * Description: TODO
 *  题目描述 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述: 输入一个int型整数
 * 输出描述: 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例1 输入 9876673 输出 37689
 * @title: Demo012
 * Created by 19040838 on 2021.01.29 10:30
 */
public class Demo012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                sb.append(c);
            }
            String result = sb.reverse().toString();
            if ("0".equals(result.substring(0, 1))) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (char c : result.toCharArray()) {
                if (set.add(c)) {
                    stringBuilder.append(c);
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
