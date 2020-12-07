package com.xjc.study.thread.thread02reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * ReentrantLock特别的功能可以使用trylock进行尝试锁定，不管锁定与否，方法都将继续进行，
 * synchronized如果搞不定就肯定阻塞了，ReentrantLock可以自己决定到底要不要wait
 * @ClassName Thread_003_ReentrantLcok
 * @Author Elvin
 * @Date 2020/12/5 16:18
 * @Version 1.0
 */
public class Thread_003_ReentrantLcok {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread_003_ReentrantLcok thread009ReentrantLcok = new Thread_003_ReentrantLcok();
        new Thread(thread009ReentrantLcok::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(thread009ReentrantLcok::m2).start();
    }

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 6; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1-----start-Thread-" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @Description TODO
     * 使用trylock进行尝试锁定，不管锁定与否，方法都将继续进行
     * 可以根据trylock的返回值来判断是否锁定
     * 也可指定trylock的时间
     * @ClassName Thread_003_ReentrantLcok
     * @Author Elvin
     * @Date 2020/12/5 16:22
     * @Version 1.0
     */

    void m2() {
        boolean locked = false;
        // 方式一：可以根据trylock的返回值来判断是否锁定
        try {
            locked = lock.tryLock();
            System.out.println("m2----start----" + locked);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }

        // 方式二
        /*try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2----start----" + locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }*/
    }
}
