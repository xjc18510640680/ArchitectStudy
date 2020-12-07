package com.xjc.study.thread.thread00;
/**
 *启动线程的三种方式：1、继承thread类  2、实现runnable接口   3、线程池Executors.newCachedThread
 * @title: Thread_000_CreateFormThreadAndRunnable
 * @Author 19040838
 * @Date: 2020.11.25 10:27
 */
public class Thread_000_CreateFormThreadAndRunnable {
    public static void main(String[] args) {
        new myThread().start();
        new Thread(new myRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
    }

    static class myThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承thread创建线程");
        }
    }

    static class myRun implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Runnerable接口创建线程");
        }
    }
}
