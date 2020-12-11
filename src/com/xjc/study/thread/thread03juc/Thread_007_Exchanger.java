package com.xjc.study.thread.thread03juc;

import java.util.concurrent.Exchanger;

/**
 * Description: TODO
 *
 * @title: Thread_007_Exchanger
 * Created by 19040838 on 2020.12.11 16:33
 */
public class Thread_007_Exchanger {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
           String str = "exchanger1";
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + str);
        }, "Thread1").start();
        new Thread(()->{
            String str = "exchanger2";
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + str);
        }, "Thread2").start();
    }
}
