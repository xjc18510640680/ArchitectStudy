package com.xjc.study.test.demo.demo20210201;

import java.util.Scanner;

/**
 * Description: TODO 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述: 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述: 输出一个整数，表示输入字符串最后一个单词的长度。
 * 示例1
 * 输入 hello nowcoder
 * 输出 8
 * @title: Demo018
 * Created by 19040838 on 2021.02.01 17:20
 */
public class Demo018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            if("" != str && str.length() <5000) {
                int index = str.lastIndexOf(" ");
                String result = str.substring(index + 1, str.length());
                System.out.println(result.length());
            }
        }
    }
}
