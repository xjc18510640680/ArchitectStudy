package com.xjc.study.test.demo.demo20210129;

import java.util.*;

/**
 * Description: TODO 题目描述 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述: 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述: 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 * @title: Demo014
 * Created by 19040838 on 2021.01.29 10:55
 */
public class Demo014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String n = sc.nextLine();
            if (!n.matches("^[0-9]*$") || Integer.parseInt(n) < 1 || Integer.parseInt(n) > 1000) {
                return;
            }
            String[] strArr = new String[Integer.parseInt(n)];
            for (int i = 0; i < Integer.parseInt(n); i++) {
                String input = sc.nextLine();
                if (input.length() > 100) {
                    return;
                }
                strArr[i] = input;
            }
            Arrays.sort(strArr);
            for (String str : strArr) {
                System.out.println(str);
            }
        }
    }
}
