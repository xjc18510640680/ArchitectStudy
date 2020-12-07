package com.xjc.study.thread.thread01sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Description: TODO
 *
 * @title: Thread_006_SyncVsAtomicXXXVsLongAdder
 * Created by 19040838 on 2020.12.01 19:58
 */
public class Thread_006_SyncVsAtomicXXXVsLongAdder {
    static Long syncCount = 0L;
    static AtomicInteger atomicIntegerCount = new AtomicInteger(0);
    static LongAdder longAdderCount = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];

        // sync
        Object lock = new Object();
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock) {
                            syncCount++;
                        }
                    }
                }
            });
        }

        Long start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        Long end = System.currentTimeMillis();
        System.out.println("Sync运行时间：" + (end - start) + " ms");

        // AtomicXXX
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    atomicIntegerCount.incrementAndGet();
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("AtomicXXX运行时间：" + (end - start) + " ms");

        // LongAdder
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    longAdderCount.increment();
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("LongAdder运行时间：" + (end - start) + " ms");
    }
}
