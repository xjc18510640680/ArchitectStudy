package com.xjc.study.thread.thread01sync;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 * 这里是继承中有可能发生的情形，子类调用父类的同步方法
 * @title: DemoSynchronized002
 * @Author 19040838
 * @Date: 2020.11.25 14:44
 */
public class Thread_004_Synchronized {

    synchronized void m() {
        System.out.println("parent m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("parent m end");
    }

    public static void main(String[] args) {
        new ChildDemoSynchronized002().m();
    }
}

class ChildDemoSynchronized002 extends Thread_004_Synchronized {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
