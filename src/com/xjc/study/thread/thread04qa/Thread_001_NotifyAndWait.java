package com.xjc.study.thread.thread04qa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 * 实现一个容器，提供两个方法，add，size。
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束。
 * @title: Thread_001_NotifyAndWait
 * Created by 19040838 on 2020.12.14 16:26
 */
public class Thread_001_NotifyAndWait {

    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Thread_001_NotifyAndWait thread001NotifyAndWait = new Thread_001_NotifyAndWait();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock) {
                System.out.println("Thread2 start");
                if(thread001NotifyAndWait.size() == 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread2 end");
                System.out.println("Thread1 continue");
                lock.notify();
            }
        }, "Thread2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("Thread1 start");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    thread001NotifyAndWait.add(new Object());
                    System.out.println("add---" + i);
                }
            }
        });
    }
}
