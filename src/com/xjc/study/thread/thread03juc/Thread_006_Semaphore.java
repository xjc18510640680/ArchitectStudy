package com.xjc.study.thread.thread03juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @title: Thread_006_Semaphore
 * Created by 19040838 on 2020.12.11 14:31
 */
public class Thread_006_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("thread1----start");
                Thread.sleep(200);
                System.out.println("thread1----end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("thread2----start");
                Thread.sleep(200);
                System.out.println("thread2----end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
    }
}
