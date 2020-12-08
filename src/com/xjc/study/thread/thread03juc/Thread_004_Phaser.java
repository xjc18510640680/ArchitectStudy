package com.xjc.study.thread.thread03juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 * 题目：5个学生一起参加考试，一共有三道题，要求所有学生到齐才能开始考试，
 * 全部同学都做完第一题，学生才能继续做第二题，全部学生做完了第二题，才能做第三题，
 * 所有学生都做完的第三题，考试才结束。
 * 分析这个题目：这是一个多线程（5个学生）分阶段问题（考试开始、第一题做完、第二题做完、第三题做完）
 * @title: Thread_004_Phaser
 * Created by 19040838 on 2020.12.08 11:30
 */
public class Thread_004_Phaser {

    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");

    static Random random = new Random();

    static void sleepmills(int mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("学生准备好了,学生人数：" + getRegisteredParties());
                    return false;
                case 1:
                    System.out.println("第一题所有学生做完");
                    return false;
                case 2:
                    System.out.println("第二题所有学生做完");
                    return false;
                case 3:
                    System.out.println("第三题所有学生做完，结束考试");
                    return false;
                default:
                    return true;
            }
        }
    }

    static class StudentTask implements Runnable {

        private Phaser phaser;

        public StudentTask(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---到达考场时间---" + sdf.format(new Date()));
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + "---做第1题开始时间---" + sdf.format(new Date()));
            sleepmills(random.nextInt(3000));
            System.out.println(Thread.currentThread().getName() + "---做第1题完成---" + sdf.format(new Date()));
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + "---做第2题时间---" + sdf.format(new Date()));
            sleepmills(random.nextInt(3000));
            System.out.println(Thread.currentThread().getName() + "---做第2题完成---" + sdf.format(new Date()));
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + "---做第3题时间---" + sdf.format(new Date()));
            sleepmills(random.nextInt(3000));
            System.out.println(Thread.currentThread().getName() + "---做第3题完成---" + sdf.format(new Date()));
            phaser.arriveAndAwaitAdvance();
        }
    }

    public static void main(String[] args) {
        MarriagePhaser phaser = new MarriagePhaser();
        StudentTask[] studentTask = new StudentTask[5];
        for (int i = 0; i < studentTask.length; i++) {
            studentTask[i] = new StudentTask(phaser);
            phaser.register();	//注册一次表示phaser维护的线程个数
        }

        Thread[] threads = new Thread[studentTask.length];
        for (int i = 0; i < studentTask.length; i++) {
            threads[i] = new Thread(studentTask[i], "Student---" + i);
            threads[i].start();
        }

        //等待所有线程执行结束
        for (int i = 0; i < studentTask.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sleepmills(5000);
        System.out.println("Phaser对象是否销毁:" + phaser.isTerminated());
    }
}
