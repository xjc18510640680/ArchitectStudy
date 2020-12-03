package com.xjc.study.designmode.singleton;

/**
 * Description: TODO
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * @title: Singleton_003_StaticInternalClass
 * Created by 19040838 on 2020.12.01 17:24
 */
public class Singleton_003_StaticInternalClass {

    private Singleton_003_StaticInternalClass(){}

    private static class Singleton_003_StaticInternalClassHolder {
        private final static Singleton_003_StaticInternalClass INSTANCE = new Singleton_003_StaticInternalClass();
    }

    public static Singleton_003_StaticInternalClass getInstance() {
        return Singleton_003_StaticInternalClassHolder.INSTANCE;
    }

    public static void show() {
        System.out.println("StaticInternalClass");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton_003_StaticInternalClass.getInstance().hashCode());
                Singleton_003_StaticInternalClass.show();
            }).start();
        }
    }
}
