package com.example.leetcode.juc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * DCL - 双重检查加锁
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/26 19:41
 */
public class DCL {

    private static volatile DCL instance = null;

    public static DCL getInstance() {

        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Future> dcls = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            dcls.add(executorService.submit(() -> {
                final DCL instance = DCL.getInstance();
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + instance);
            }));
        }

    }

}
