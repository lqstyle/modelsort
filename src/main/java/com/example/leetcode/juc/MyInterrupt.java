package com.example.leetcode.juc;

import java.util.concurrent.TimeUnit;

public class MyInterrupt {
    public static void main(String[] args) {
        /**
         * 1、若当前线程调用了sleep ， join ，wait 响应中断，中断后会被清除中断标记状态
         * 2、若当前线程正常运行，调用中断不会清除中断状态
         * 3、若当前线程调用了park方法阻塞，中断后需要手动清除中断状态，否则再次park无法暂定当前线程
         * 常用中断方法 isInterrupted interrupted  interrupt
         * Thread.interruped 底层调用 Thread.currentThread().isInterrupted(true) 清除中断状态
         * Thread.currentThread().isInterrupted(false) 不清除中断状态
         * 其他线程调用 thread.interrupt 打断线程，被打断线程的中断标记为true
         */

//        sleep();
//        testJoin();
        testRunning();


    }

    private static void testRunning() {

        Thread thread = new Thread(() -> {
            System.out.println("i am running");
            while (true) {

            }
        });
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    private static void sleep() {
        Thread thread1 = getThread();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.interrupt();

        System.out.println("t1线程中断状态2" + thread1 + " " + thread1.isInterrupted());
    }

    private static Thread getThread() {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("t1线程中断状态1" + Thread.currentThread() + " " + Thread.currentThread().isInterrupted());
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("t1线程中断状态3" + Thread.currentThread() + " " + Thread.currentThread().isInterrupted());
            }
        });
        thread1.start();
        return thread1;
    }


    private static void testJoin() {
        Thread thread1 = getThreadJoin();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("main线程中断状态2" + Thread.currentThread() + " " + Thread.currentThread().isInterrupted());
        }

        System.out.println("main线程中断状态1" + thread1 + " " + Thread.currentThread().isInterrupted());
    }

    private static Thread getThreadJoin() {
        Thread thread1 = new Thread(() -> {
            System.out.println("t1线程中断状态1" + Thread.currentThread() + " " + Thread.currentThread().isInterrupted());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.currentThread().interrupt();
        });
        thread1.start();
        return thread1;
    }
}
