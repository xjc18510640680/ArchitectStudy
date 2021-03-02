package com.xjc.study.designmode.singleton;

/**
 * Description: TODO
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 1、可以通过synchronized解决，但也带来效率下降
 * 2、通过减小同步代码块的方式提高效率，然后不可行
 * @author 19040838
 * @title: Singleton_002_LazyMan
 * Created by 19040838 on 2020.12.01 16:52
 */
public class Singleton_002_LazyMan {
    private static volatile Singleton_002_LazyMan INSTANCE;

    private Singleton_002_LazyMan() {}

    public static /*synchronized*/ Singleton_002_LazyMan getInstance() {
        if(INSTANCE == null) {
            // 妄图通过减小同步代码块的方式提高效率，然后不可行
            synchronized (Singleton_002_LazyMan.class) {
                // 双重检查 可以解决
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton_002_LazyMan();
                }
            }
        }
        return INSTANCE;
    }

    public void show() {
        System.out.println("lazyMan");
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            new Thread(()->
                    System.out.println(Singleton_002_LazyMan.getInstance().hashCode())
            ).start();
        }
    }
}
