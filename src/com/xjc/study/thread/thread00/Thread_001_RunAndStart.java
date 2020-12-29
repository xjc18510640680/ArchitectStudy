package com.xjc.study.thread.thread00;

import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @title: Thread_001_RunAndStart
 * Created by 19040838 on 2020.12.28 17:02
 */
public class Thread_001_RunAndStart {
    private static class t1 extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("t1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        new t1().run();
        new t1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
