package com.example.lamda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMyInterface {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int a = 1;
        int b = 2;
//        test(a, b, (c, d) -> (int) c + (int) d);

        test12(a, b);
    }

    public static Integer test(int a, int b, BiFunction function) {

        if (a == 0) {
            return 1;
        }


        int i = a + (int) function.apply(a, b);

        if (i != 0) {
            return 1;
        }

        return i;
    }

    public static Integer test2(int a, int b, BiFunction<MyFunctionInterface, Integer, Integer> function, MyFunctionInterface myFunctionInterface) {

        if (a == 0) {
            return 1;
        }


        int i = a + (int) function.apply(myFunctionInterface, b);

        if (i != 0) {
            return 1;
        }

        return i;
    }

    public static void test12(int a, int b) {
        test2(a, b, (t, u) -> {
            return t.getNumber(a, b) + (int) u;
        }, (e, f) -> {
            return e * f;
        });

    }
}
