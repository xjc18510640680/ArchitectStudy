package com.xjc.study.designmode.singleton;

/**
 * Description: TODO
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 * @author 19040838
 * @title: Singleton_001_EvilMan
 * Created by 19040838 on 2020.11.30 16:46
 */
public class Singleton_001_EvilMan {

    private static final Singleton_001_EvilMan INSTANCE = new Singleton_001_EvilMan();

//    private static final Singleton_001_EvilMan INSTANCE;
//    static {
//        INSTANCE = new Singleton_001_EvilMan();
//    }

    public static Singleton_001_EvilMan getInstance() {
        return INSTANCE;
    }

    private Singleton_001_EvilMan() {}

    public void show(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Singleton_001_EvilMan singleton_001_eHan = Singleton_001_EvilMan.getInstance();
        Singleton_001_EvilMan singleton_001_eHan1 = Singleton_001_EvilMan.getInstance();
        singleton_001_eHan.show();
        System.out.println(singleton_001_eHan == singleton_001_eHan1);
    }
}
