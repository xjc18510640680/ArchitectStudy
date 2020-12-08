package com.xjc.study.thread.thread03juc;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description: TODO
 *
 * @title: Thread_005_ReadWriteLock
 * Created by 19040838 on 2020.12.08 14:18
 */
public class Thread_005_ReadWriteLock {
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    public static void read(Lock lock, int index) {
        try {
            lock.lock();
            System.out.println("读Thread-" + index + "开始");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("读Thread-" + index + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int index) {
        try {
            lock.lock();
            System.out.println("写Thread-" + index + "开始");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("写Thread-" + index + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 18; i++) {
            int finalI = i;
            new Thread(()->read(readLock, finalI)).start();
        }

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(()->write(writeLock, finalI)).start();
        }
    }
}
