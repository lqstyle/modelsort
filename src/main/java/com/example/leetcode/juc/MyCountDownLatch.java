package com.example.leetcode.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.submit(() -> {
                try {
                    System.out.println("i am one " + Thread.currentThread());
                } finally {
                    countDownLatch.countDown();
                }
            });
            executorService.submit(() -> {
                try {
                    System.out.println("i am two " + Thread.currentThread());
                } finally {
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i am main run " + Thread.currentThread());
        }
    }
}
