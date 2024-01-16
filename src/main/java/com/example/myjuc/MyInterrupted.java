package com.example.myjuc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MyInterrupted {

    public static void main(String[] args) {


        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);


        thread.start();
        log.info("{} thread is interrupted0  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
        thread.interrupt();
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                log.info("{} thread is interrupted1  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                log.info("{} thread is interrupted2  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                log.info("{} thread is interrupted3  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                Thread.interrupted();
                log.info("{} thread is interrupted3  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            }
        }
    }


    static class MyTask1 implements Runnable {

        @Override
        public void run() {
            log.info("{} thread is interrupted4  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            while (true) {
                log.info("{} thread is interrupted5  status {}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        }
    }
}
