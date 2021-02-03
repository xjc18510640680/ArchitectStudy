package com.xjc.study.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Description: TODO
 *
 * @title: Test
 * Created by 19040838 on 2021.02.02 19:24
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 5L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(8));
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> faFutureTask = (Future<String>) threadPoolExecutor.submit(new TestThreadPoll(String.valueOf(i)));
            futureList.add(faFutureTask);
        }
        for (Future<String> future : futureList) {
            future.get();
        }
        threadPoolExecutor.shutdown();
    }
}
class TestThreadPoll implements Runnable {
    private final String name;
    TestThreadPoll(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "当前线程名称：" + Thread.currentThread().getName());
//        return name;
    }
}