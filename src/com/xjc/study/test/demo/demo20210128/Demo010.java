package com.xjc.study.test.demo.demo20210128;

import java.util.Scanner;

/**
 * Description: TODO 题目描述 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * 输入描述: 输入一个long型整数
 * 输出描述: 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * 示例1 输入 180 输出 2 2 3 3 5
 * @title: Demo010
 * Created by 19040838 on 2021.01.28 15:53
 */
public class Demo010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long input = sc.nextLong();
            getPrimer(input);
        }
    }

    public static void getPrimer(long input){
        for (int i= 2;i <= input; i++){
            if (input % i==0){
                System.out.print(i + " ");
                getPrimer(input/i);
                break;
            }
            if (i==input){
                System.out.print( i + "");
            }
        }
    }
}
