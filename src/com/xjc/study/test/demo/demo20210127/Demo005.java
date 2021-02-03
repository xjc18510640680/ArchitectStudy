package com.xjc.study.test.demo.demo20210127;

import java.util.Scanner;

/**
 * Description: TODO
 *
 * @title: Demo005
 * Created by 19040838 on 2021.01.27 16:50
 */
public class Demo005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.nextLine());
            System.out.println(sb.reverse().toString());
        }
    }
}
