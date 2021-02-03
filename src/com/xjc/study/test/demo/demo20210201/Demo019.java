package com.xjc.study.test.demo.demo20210201;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: TODO 题目描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。当没有新的输入时，说明输入结束。
 * 输入描述: 注意：输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
 * 输出描述: 返回多行，处理后的结果
 * 示例1
 * 输入
 * 3
 * 2
 * 2
 * 1
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 * 输出
 * 1
 * 2
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 * @title: Demo019
 * Created by 19040838 on 2021.02.01 19:21
 */
public class Demo019 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] array = new int[n];
            for(int i=0;i<n;i++){
                array[i] = scan.nextInt();
            }
            Arrays.sort(array);
            //对排好序的数组中重复的数组进行选择输出，首先输出第一个数
            System.out.println(array[0]);
            for(int i=1;i<n;i++){
                if(array[i] != array[i-1]) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
