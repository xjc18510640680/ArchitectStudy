package com.xjc.study.thread.thread03juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Description: TODO
 *
 * @title: Thread_008_LockSupport
 * Created by 19040838 on 2020.12.11 16:42
 */
public class Thread_008_LockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    if(i == 5) {
                        LockSupport.park();
                        System.out.println("tingyixia");
                        TimeUnit.SECONDS.sleep(5);
                    } else {
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        LockSupport.unpark(t);

        /*try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);*/
    }
}
