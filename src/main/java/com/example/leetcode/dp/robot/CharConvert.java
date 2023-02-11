package com.example.leetcode.dp.robot;

public class CharConvert {
    public static void main(String[] args) {
        String s = "9100";
        char[] c = s.toCharArray();
        System.out.println(ways(c, 0));
        System.out.println(ways1(c));
    }

    public static int ways(char[] c, int index) {
        return process(c, index);
    }

    public static int ways1(char[] c) {
        return process1(c);
    }

    public static int process(char[] c, int index) {
        if (index == c.length) {
            return 1;
        }
        if (c[index] == '0') {
            return 0;
        }

        // 处理单个字符转换
        int ways = process(c, index + 1);
        // 处理多个字符转换 两个连续的字符差值不能超过26
        if (index + 1 < c.length && (c[index] - '0') + 10 + c[index + 1] - '0' < 27) {
            ways += process(c, index + 2);
        }
        return ways;
    }


    public static int process1(char[] c) {
        int n = c.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;


        for (int i = n - 1; i >= 1; i--) {
            if (c[i] != '0') {
                // 处理单个字符转换
                int ways = dp[i + 1];
                // 处理多个字符转换 两个连续的字符差值不能超过26
                if (i + 1 < c.length && (c[i] - '0') + 10 + c[i + 1] - '0' < 27) {
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }
}
