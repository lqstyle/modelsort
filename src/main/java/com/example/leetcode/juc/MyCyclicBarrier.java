package com.example.leetcode.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i <3 ; i++) {
            executorService.submit(()->{
                System.out.println("i am one wait "+Thread.currentThread());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("i am one ,working"+Thread.currentThread());
            });

            executorService.submit(()->{
                System.out.println("i am two wait "+Thread.currentThread());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("i am two ,working"+Thread.currentThread());
            });

            executorService.submit(()->{
                System.out.println("i am three wait "+Thread.currentThread());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("i am three ,working"+Thread.currentThread());
            });
        }
    }
}
