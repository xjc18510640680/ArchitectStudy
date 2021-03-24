package com.xjc.study.thread.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @author 19040838
 * @title: TestThreadPool
 * Created by 19040838 on 2021.03.16 11:32
 */
public class TestThreadPool {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
        TimeUnit unit = TimeUnit.SECONDS;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 
                60, unit, linkedBlockingQueue, handler);
        for (int i = 0; i < 16; i++) {
            threadPoolExecutor.execute(new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPoolExecutor.getPoolSize());
            if (linkedBlockingQueue.size() > 0) {
                System.out.println("----------------队列中阻塞的线程数" + linkedBlockingQueue.size());
            }
        }
        threadPoolExecutor.shutdown();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        Object proxy = null;
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
    }
}

class ThreadPoolTest implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
