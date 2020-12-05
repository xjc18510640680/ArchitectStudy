package com.xjc.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * reentrantLock用于替代synchronized实现可重入锁
 * 但是ReentrantLock必须手动解锁lock.unlock()
 * sync会自动释放锁
 * @ClassName Thread_008_ReentrantLock
 * @Author Elvin
 * @Date 2020/12/5 15:55
 * @Version 1.0
 */
public class Thread_008_ReentrantLock {

    public static void main(String[] args) {
        Thread_007_ReentrantLock thread007ReentrantLock = new Thread_007_ReentrantLock();
        new Thread(thread007ReentrantLock::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(thread007ReentrantLock::m2).start();
    }

    Lock lock = new ReentrantLock();

    void m1() {
        // 相当于synchronized(this)
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1-----start" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 必须手动释放锁
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lock();
            System.out.println("m2----start");
        } finally {
           lock.unlock();
        }
    }
}
