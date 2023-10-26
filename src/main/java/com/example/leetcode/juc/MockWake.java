package com.example.leetcode.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * MockWake - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/26 15:24
 */
@Slf4j
public class MockWake {

    private static int number = 0;

    static MockWake mockWake = new MockWake();

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition = reentrantLock.newCondition();
    static Condition condition1 = reentrantLock.newCondition();

    public MockWake() {
    }

    public static void main(String[] args) {
        mySynchronized();
    }

    private static void mySynchronized() {

        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            synchronized (mockWake) {
                while (number == 0) {
                    log.info("线程没有获得到许可，暂停 {}", Thread.currentThread().getName());
                    try {
                        mockWake.wait();
                    } catch (InterruptedException e) {
                        log.error("线程异常!");
                    }
                }
                number--;
                log.info("线程获得到许可，结束 {} , number : {}", Thread.currentThread().getName(), number);
            }
        });

        executorService.submit(() -> {
            synchronized (mockWake) {
                while (number == 0) {
                    log.info("线程没有获得到许可，暂停 {}", Thread.currentThread().getName());
                    try {
                        mockWake.wait();
                    } catch (InterruptedException e) {
                        log.error("线程异常!");
                    }
                }
                number--;
                log.info("线程获得到许可，结束 {} , number : {}", Thread.currentThread().getName(), number);
            }
        });
        synchronized (mockWake) {
            number++;
            mockWake.notifyAll();
        }
        log.info("结束 {}", Thread.currentThread().getName());
    }

    private static void myLock() {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {

            reentrantLock.lock();
            try {
                if (number == 0) {
                    log.info("线程没有获得到许可，暂停 {}", Thread.currentThread().getName());
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        log.error("线程异常!");
                    }
                }
                number--;
                log.info("线程获得到许可，结束 {} , number : {}", Thread.currentThread().getName(), number);
            } finally {
                reentrantLock.unlock();
            }

        });

        executorService.submit(() -> {
            reentrantLock.lock();
            try {
                if (number == 0) {
                    log.info("线程没有获得到许可，暂停 {}", Thread.currentThread().getName());
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        log.error("线程异常!");
                    }
                }
                number--;
                log.info("线程获得到许可，结束 {} , number : {}", Thread.currentThread().getName(), number);
            } finally {
                reentrantLock.unlock();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        try {
            number++;
            condition.signal();
        } finally {
            reentrantLock.unlock();
        }

        reentrantLock.lock();
        try {
            number++;
            condition1.signal();
        } finally {
            reentrantLock.unlock();
        }
        log.info("结束 {}", Thread.currentThread().getName());

    }

}
