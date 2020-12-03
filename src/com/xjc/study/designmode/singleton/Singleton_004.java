package com.xjc.study.designmode.singleton;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Description: TODO
 * 不仅可以解决线程同步，还可以防止反序列化。
 * @title: Singleton_004
 * Created by 19040838 on 2020.12.01 18:57
 */
public enum Singleton_004 {
    INSTANCE;

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton_004.INSTANCE.hashCode());
            }).start();
        }
    }
}
