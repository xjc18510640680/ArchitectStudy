package com.xjc.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * ReentrantLock还可以指定为公平锁，所谓公平锁就是后来的线程在队列中等待，让已有线程先执行完了在执行后来的。
 * ReentrantLock默认是非公平锁。ReentrantLock(true)的时候才是公平锁。
 * @ClassName Thread_011_ReentrantLcok
 * @Author Elvin
 * @Date 2020/12/5 20:25
 * @Version 1.0
 */
public class Thread_011_ReentrantLcok extends Thread {

    public static void main(String[] args) {
        Thread_011_ReentrantLcok thread011ReentrantLcok = new Thread_011_ReentrantLcok();
        Thread thread1 = new Thread(thread011ReentrantLcok);
        Thread thread2 = new Thread(thread011ReentrantLcok);
        thread1.start();
        thread2.start();
    }

    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "-" +i + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }
}
