package com.xjc.study.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: TODO
 *
 * @title: AlternatingPrint_001_ReentrantLock
 * Created by 19040838 on 2021.01.13 10:31
 */
public class AlternatingPrint_001_ReentrantLock {

    public static void main(String[] args) {
        char[] words = "ABCDEFG".toCharArray();
        char[] numbers = "1234567".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                for (char word : words) {
                    System.out.print(word);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "T1").start();
        new Thread(()->{
            try {
                lock.lock();
                for (char number : numbers) {
                    System.out.print(number);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "T2").start();
    }
}
