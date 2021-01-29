package com.xjc.study.test.demo.demo20210127;

import java.util.Scanner;

/**
 * Description: TODO
 *
 * @title: Demo004
 * Created by 19040838 on 2021.01.27 16:02
 */
public class Demo004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String result = Integer.toBinaryString(num);
            int count = 0;
            for (char c : result.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
