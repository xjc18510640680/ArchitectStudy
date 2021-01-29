package com.xjc.study.test.demo.demo20210128;

import java.util.Scanner;

/**
 * Description: TODO 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 本题有多组数据。
 * 输入描述: 输入int型表示month 输出描述: 输出兔子总数int型
 * 示例1 输入 9 输出 34
 * @title: Demo007
 * Created by 19040838 on 2021.01.28 9:08
 */
public class Demo007 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            System.out.println(Fibonacci(n));
        }
    }
    private static int Fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
