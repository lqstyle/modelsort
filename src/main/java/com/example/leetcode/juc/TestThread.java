package com.example.leetcode.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {


    public static void main(String[] args) {
        Animal1 animal = new Animal1("kimi");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1; i++) {
            executorService.submit(() -> {
                try {
                    doEat(animal);
                    System.out.println("1" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.submit(() -> {
                try {
                    doEat(animal);
                    System.out.println("2" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


    private static void doEat(Animal1 animal) throws InterruptedException {
        animal.noEat(animal.getName(), animal.getNum());
        animal.eat(animal.getName(), animal.getNum());
        animal.noEat("lq", animal.getNum());
    }
}

class Animal1 {
    private String name;

    private volatile int num;

    public void eat(String name, int number) {
        System.out.println(name + ": food is coming, begin eat number: " + num + " " + Thread.currentThread().getName());
    }

    public void noEat(String name, int number) {
        System.out.println(name + ": no food is coming, please wait number: " + num + " " + Thread.currentThread().getName());
    }

    public Animal1(String name) {
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

