package com.example.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class TestMyInterface {

    public static void main(String[] args) {
        String digits = "";
        letterCombinations(digits);
//        test1();
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
        test2(a, b, getResult(a, b), myInterfaceCalc());

    }

    private static MyFunctionInterface myInterfaceCalc() {
        return (e, f) -> {
            return e * f;
        };
    }

    private static BiFunction<MyFunctionInterface, Integer, Integer> getResult(int a, int b) {
        return (t, u) -> {
            return t.getNumber(a, b) + (int) u;
        };
    }


    public static List<String> letterCombinations(String digits) {


        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, String> map = new HashMap() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        dfs(result, sb, digits, map, digits.length(), 0);
        return result;
    }

    public static void dfs(List<String> result, StringBuilder sb, String digits, Map<Character, String> map, int length, int index) {

        if (length == sb.length()) {
            result.add(sb.toString());
            return;
        }

        String target = map.get(digits.charAt(index));
        char[] cs = target.toCharArray();
        for (char c : cs) {
            sb.append(c);
            dfs(result, sb, digits, map, length, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
