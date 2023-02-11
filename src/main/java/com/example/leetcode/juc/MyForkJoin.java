package com.example.leetcode.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class MyForkJoin {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyTask myTask = new MyTask(5);
        Integer invoke = forkJoinPool.invoke(myTask);
        System.out.println(invoke);
    }

}

/**
 *
 */
@Slf4j
class MyTask extends RecursiveTask<Integer> {

    private int n;

    @Override
    protected Integer compute() {
        if (n == 1) {
            log.info("join {}", n);
            return 1;
        }
        MyTask myTask = new MyTask(n - 1);
        myTask.fork();
        log.info("fork {}  {}", n, myTask);

        int result = n + myTask.join();
        log.info("join {}  {} {}", n, myTask, result);
        return result;
    }

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "n=" + n;
    }
}
