package com.xjc.study.test.demo.demo20210127;

import java.util.Scanner;

/**
 * Description: TODO
 *
 * @title: demo003
 * Created by 19040838 on 2021.01.27 15:22
 */
public class demo003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //输入参数
            double a = in.nextDouble();
            //取整数部分
            int b = (int) a;
            //判断
            if ((a - b) >= 0.5) {
                b = (int) (a + 0.5);
            }
            System.out.println(b);
        }
    }
}
