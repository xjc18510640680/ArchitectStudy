package com.xjc.study.thread.thread03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @title: Thread_001_CountDownLatch
 * Created by 19040838 on 2020.12.07 17:26
 */
public class Thread_001_CountDownLatch {

    public static void main(String[] args) {
        countDownLatch();
    }

    public static void countDownLatch() {
        Thread[] threads = new Thread[5];
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                int count = 0;
                System.out.println("子线程-" + Thread.currentThread().getName() + "-" + finalI + "-start");
                try {
                    TimeUnit.SECONDS.sleep(threads.length);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程-" + Thread.currentThread().getName() + "-" + finalI + "-end");
                countDownLatch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            countDownLatch.await();
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
