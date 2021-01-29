package com.xjc.study.test;

/**
 * Description: TODO
 *交替打印
 * @title: AlternatingPrint_001_Wait_Notify
 * Created by 19040838 on 2021.01.13 10:46
 */
public class AlternatingPrint_001_Wait_Notify {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        final Object o = new Object();
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();
        new Thread(()->{
            synchronized (o) {
                while (!flag) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (char word : words) {
                    System.out.print(word);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "T1").start();
        new Thread(()->{
            synchronized (o) {
                for (char number : numbers) {
                    System.out.print(number);
                    flag = true;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "T2").start();
    }
}
