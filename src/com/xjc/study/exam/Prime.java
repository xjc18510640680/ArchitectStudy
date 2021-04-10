package com.xjc.study.exam;

import java.util.Scanner;

/**
 * Description: TODO
 *  质因子数
 * @author 19040838
 * @title: Prime
 * Created by 19040838 on 2021.03.24 9:20
 */
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        getPrimer2(input);
    }

    /**
     * 方法一
     **/
    public static void getPrimer1(long num){
        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }

    /**
     * 最优解
     **/
    public static void getPrimer2(long num){
        long k = (long) Math.sqrt(num);
        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "": num+" ");
    }

    /**
     * 方法三
     **/
    public static void getPrimer(long num){
        for (int i= 2;i <= num; i++){
            if (num % i == 0){
                System.out.print(i + " ");
                getPrimer(num / i);
                break;
            }
            if (i == num){
                System.out.print( i + "");
            }
        }
    }
}
