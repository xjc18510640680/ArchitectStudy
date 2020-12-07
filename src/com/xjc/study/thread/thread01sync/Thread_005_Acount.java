package com.xjc.study.thread.thread01sync;

import java.util.concurrent.TimeUnit;

/**
 *面试题：模拟银行账户
 *  对业务写方法加锁
 *  业务读方法不加锁
 *  这样行不行？
 *
 *  容易产生脏读问题（dirtyRead）
 * @title: Thread_005_Acount
 * @Author 19040838
 * @Date: 2020.11.25 11:39
 */
public class Thread_005_Acount {
    private String name;
    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return this.balance = balance;
    }

    public static void main(String[] args) {
        Thread_005_Acount dat = new Thread_005_Acount();
        new Thread(()->dat.set("lisi", 1000.00)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询余额为：" + dat.getBalance("lisi"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询余额为：" + dat.getBalance("lisi"));
    }
}
