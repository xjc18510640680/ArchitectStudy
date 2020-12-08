package com.xjc.study.thread.thread03juc;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @title: Thread_003_Phaser
 * Created by 19040838 on 2020.12.08 10:56
 */
public class Thread_003_Phaser {
    static Random random = new Random();
    static MarriagePhaser marriagePhaser = new MarriagePhaser();

    static void sleepMills(int mills) {
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
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person implements Runnable {

        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            sleepMills(random.nextInt(3000));
            System.out.printf("%s 到达现场! \n", name);
            marriagePhaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            sleepMills(random.nextInt(3000));
            System.out.printf("%s 吃完! \n", name);
            marriagePhaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            sleepMills(random.nextInt(3000));
            System.out.printf("%s 离开! \n", name);
            marriagePhaser.arriveAndAwaitAdvance();
        }

        private void hug() {
            if("新郎".equals(name) || "新娘".equals(name)) {
                sleepMills(random.nextInt(3000));
                System.out.printf("%s 洞房! \n", name);
                marriagePhaser.arriveAndAwaitAdvance();
            } else {
                marriagePhaser.arriveAndAwaitAdvance();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }

    public static void main(String[] args) {
        marriagePhaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("宾客" + i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }
}
