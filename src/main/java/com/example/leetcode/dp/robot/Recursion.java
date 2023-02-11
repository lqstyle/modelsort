package com.example.leetcode.dp.robot;

import java.util.Arrays;

/**
 * 机器人行走路线方法数
 * start： 开始位置
 * aim： 最终目的地
 * n：   数总数
 * rest： 步数
 * 从1->2
 * 从n->n-1
 * 非1和n可以往前走和往回走
 * <p>
 * n:1 2 3 4
 * start: 2
 * aim: 4
 * rest:  4
 * <p>
 * 暴力递归，动态规划是结果，不是原因
 * 通过递归-> 记忆化搜索（缓存法）-> 动态规划(图表法)
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(ways3(2, 4, 4, 4));
    }

    public static int ways(int start, int k, int aim, int n) {
        return process(start, k, aim, n);
    }

    /**
     * @param cur  当前机器人所在的位置
     * @param rest 剩余可以行走的步数
     * @param aim  最终目的地
     * @param n    数总量
     * @return 行走的方法数
     */
    public static int process(int cur, int rest, int aim, int n) {
        // 递归退出条件
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        // cur =1 只能往2 走
        if (cur == 1) {
            return process(2, rest - 1, aim, n);
        }

        if (cur == n) {
            //cur =n 只能往N-1走
            return process(n - 1, rest - 1, aim, n);
        }

        // 非cur=1和cur=n。可以往左和右走
        return process(cur - 1, rest - 1, aim, n) + process(cur + 1, rest - 1, aim, n);

    }


    /**
     * 带有缓存的暴力递归，记忆化搜索
     * @param start
     * @param k
     * @param aim
     * @param n
     * @return
     */
    public static int ways1(int start, int k, int aim, int n) {
        // k 范围0-k
        // n 范围1-n  二维数组存储 dp[n+1][k+1]  设置初始化值为-1
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=k ; j++) {
                dp[i][j]=-1;
            }
        }
        return processWithCache(start, k, aim, n,dp);
    }

    public static int processWithCache(int cur, int rest, int aim, int n,int[][] dp) {
        if(dp[cur][rest]!=-1){
            return dp[cur][rest];
        }

        int result = 0;
        // 递归退出条件
        if (rest == 0) {
            result= cur == aim ? 1 : 0;
        }else if (cur == 1) {
            // cur =1 只能往2 走
            result  =  process(2, rest - 1, aim, n);
        }else if (cur == n) {
            //cur =n 只能往N-1走
            result =  process(n - 1, rest - 1, aim, n);
        }else{
            // 非cur=1和cur=n。可以往左和右走
            result =  process(cur - 1, rest - 1, aim, n) + process(cur + 1, rest - 1, aim, n);
        }

        dp[cur][rest] = result;
        return result;

    }


    public static int ways2(int start, int k, int aim, int n) {
        // k 范围0-k
        // n 范围1-n  二维数组存储 dp[n+1][k+1]  设置初始化值为-1
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=k ; j++) {
                dp[i][j]=-1;
            }
        }
        return processWithCache(start, k, aim, n,dp);
    }

    public static int ways3(int start, int k, int aim, int n) {
        // k 范围0-k
        // n 范围1-n  二维数组存储 dp[n+1][k+1]
        int[][] dp = new int[n+1][k+1];
        return processWithDp(start, k, aim, n,dp);
    }
    public static int processWithDp(int start, int k, int aim, int n, int[][] dp) {

        // Base  填充n行 第一列
        dp[aim][0] = 1;
        // 填充 按照列填充，先遍历列，再遍历行，k从第一列开始遍历
        for (int i = 1; i <= k; i++) {

            // 第一行
            dp[1][i] = dp[2][i - 1];

            for (int j = 2; j < n; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
            }
            // 第n 行
            dp[n][i] = dp[n - 1][i - 1];
        }

        return dp[start][k];
    }
}
