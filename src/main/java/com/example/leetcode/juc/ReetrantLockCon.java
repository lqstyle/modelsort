package com.example.leetcode.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockCon {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition notfull = reentrantLock.newCondition();
    public static Condition notEmpty = reentrantLock.newCondition();

    public static void main(String[] args) {
        Animal animal = new Animal("kimi");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1; i++) {
            executorService.submit(() -> {
                try {
                    doEat(animal);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.submit(() -> {
                try {
                    doWait(animal);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private static void doWait(Animal animal) throws InterruptedException {
        reentrantLock.lock();

        try {
            if (animal.getNum() == 1) {
                notEmpty.await();
            }
            animal.noEat(animal.getName(), animal.getNum());
            animal.setNum(1);
            notfull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private static void doEat(Animal animal) throws InterruptedException {
        reentrantLock.lock();

        try {
            if (animal.getNum() == 0) {
                notfull.await();
            }
            animal.eat(animal.getName(), animal.getNum());
            animal.setNum(0);
            notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}

class Animal {
    private String name;

    private volatile int num;

    public void eat(String name, int number) {
        System.out.println(name + ": food is coming, begin eat number: " + num);
    }

    public void noEat(String name, int number) {
        System.out.println(name + ": no food is coming, please wait number: " + num);
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
