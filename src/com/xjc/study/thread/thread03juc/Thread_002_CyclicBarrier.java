package com.xjc.study.thread.thread03juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @title: Thread_002_CyclicBarrier
 * Created by 19040838 on 2020.12.08 9:52
 */
public class Thread_002_CyclicBarrier {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,
                ()-> System.out.println("时间-" + sdf.format(new Date()) + "-回调线程-工作线程到达屏障点后开始执行"));
        for (int i = 0; i < 5; i++) {
            String name = "Thread-" + i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("时间-" + sdf.format(new Date()) + "-工作线程-" + name + " 完成任务，进入屏障点，等待其他线程");
                    cyclicBarrier.await();
                    System.out.println("时间-" + sdf.format(new Date()) + "-工作线程-" + name + " 所有线程已进入屏障点，继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
