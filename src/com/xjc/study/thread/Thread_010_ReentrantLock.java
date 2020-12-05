package com.xjc.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * @ClassName Thread_010_ReentrantLock
 * @Author Elvin
 * @Date 2020/12/5 20:00
 * @Version 1.0
 */
public class Thread_010_ReentrantLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread thread1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("thread1 end");
            } catch (InterruptedException e) {
                System.out.println("thread1 interrupted");
            } finally {
                lock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            try {
//                lock.lock();
                lock.lockInterruptibly();
                System.out.println("thread2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("thread2 end");
            } catch (InterruptedException e) {
                System.out.println("thread2 interrupted");
            } finally {
                lock.unlock();
            }
        });
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
}
