package com.xjc.study.designmode.singleton;

/**
 * Description: TODO
 * 不仅可以解决线程同步，还可以防止反序列化。
 * @author 19040838
 * @title: Singleton_004
 * Created by 19040838 on 2020.12.01 18:57
 */
public enum Singleton_004 {
    /**
     *枚举类没有构造方法所以不会被反序列化
     */
    INSTANCE;

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton_004.INSTANCE.hashCode());
            }).start();
        }
    }
}
