package com.xjc.study.thread.thread01sync;
/**
 *同步和非同步方法是否可以同时调用？
 * @title: Thread_001_Synchronized
 * @Author 19040838
 * @Date: 2020.11.25 11:21
 */
public class Thread_001_Synchronized {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "---m1----start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---m1-----end");
    }

    public synchronized void m2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---m2");
    }

    public static void main(String[] args) {
        Thread_001_Synchronized ds = new Thread_001_Synchronized();

        new Thread(()->ds.m1(), "t1").start();
        new Thread(()->ds.m2(), "t2").start();

/*
        new Thread(ds::m1, "t1").start();
        new Thread(ds::m2, "t2").start();
*/

		/*
		//1.8之前的写法
		new Thread(new Runnable() {
			@Override
			public void run() {
				ds.m1();
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				ds.m1();
			}
		});
		*/
    }
}
