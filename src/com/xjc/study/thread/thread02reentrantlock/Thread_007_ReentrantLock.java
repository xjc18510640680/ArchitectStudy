package com.xjc.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * reentrantLock用于替代synchronized 可重入锁
 * synchronized实现方式
 * @ClassName Thread_007_ReentrantLock
 * @Author Elvin
 * @Date 2020/12/5 15:40
 * @Version 1.0
 */
public class Thread_007_ReentrantLock {

    public static void main(String[] args) {
        Thread_007_ReentrantLock thread007ReentrantLock = new Thread_007_ReentrantLock();
        new Thread(thread007ReentrantLock::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1----start" + i);
            if (2 == i) {
                m2();
            }
        }
    }

    synchronized void m2() {
        System.out.println("m2----start");
    }
}
