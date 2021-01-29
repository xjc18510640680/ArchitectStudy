package com.xjc.study.test.demo.demo20210128;

import java.util.Scanner;

/**
 * Description: TODO 写出一个程序，接受十六进制的数，输出该数值的十进制表示。可输入多个
 * 例如： 输入 0xA 0xAA
 * 输出 10 170
 * @title: Demo009
 * Created by 19040838 on 2021.01.28 15:46
 */
public class Demo009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            int integer = Integer.parseInt(input.substring(2), 16);
            System.out.println(integer);
        }
    }
}
