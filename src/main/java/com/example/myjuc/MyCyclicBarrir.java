package com.example.myjuc;

import java.util.concurrent.*;

public class MyCyclicBarrir {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier= new CyclicBarrier(10);

        ExecutorService newedFixedThreadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            newedFixedThreadPool.execute(()->{

                try {
                    TimeUnit.SECONDS.sleep(4);
                    cyclicBarrier.await();
                    System.out.println("第%i位选手已就位"+finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

            });
        }


    }
}
