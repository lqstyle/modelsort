package com.example.leetcode.dp.robot;

/**
 * 背包
 * w[]  重量
 * v[] 价值
 * bag 包能装的总重量
 * 总体策略，先尝试写出暴力递归，然后改写成动态规划
 * 查找w[]顺序，可以选择从前往后查找，或者从后往前查找
 * 此方案选择从前往后查找，即index为0开始
 */
public class Bag {
    public static void main(String[] args) {
        char s = '1';
        System.out.println(s - '0');
        int[] w = new int[]{3, 2, 4, 7, 3, 1, 7};
        int[] v = new int[]{5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(w, v, bag));
    }

    public static int maxValue(int[] w, int[] v, int bag) {
        return processWithDP(w, v, bag);
    }

    /**
     * 尝试写出递归调用体
     *
     * @param w
     * @param v
     * @param index
     * @param bag
     * @return
     */
    public static int process(int[] w, int[] v, int index, int bag) {

        // 背包容量装完后，超过背包的最大值，此次查找返回无效价值
        if (bag < 0) {
            return -1;
        }

        // base 退出条件  从0找到最后的位置，返回0价值
        if (index == w.length) {
            return 0;
        }

        // 1、要当前index 重量对应的value   2、 不要当前index重量的value   两者取最大值
        int p1 = process(w, v, index + 1, bag);

        int rest = process(w, v, index + 1, bag - w[index]);
        int p2 = 0;
        if (rest != -1) {
            p2 = v[index] + rest;
        }
        return Math.max(p1, p2);

    }


    /**
     * 尝试写出递归调用体
     *
     * @param w
     * @param v
     * @param index
     * @param bag
     * @return
     */
    public static int processWithDP(int[] w, int[] v, int bag) {

        int n = w.length;
        int[][] dp = new int[n + 1][bag + 1];
        /**
         *  每个单元格的填充都依赖下一行，所以从下往上遍历行
         */
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index+1][rest];
                int next = rest - w[index]<0?-1:dp[index+1][rest-w[index]];
                int p2 = 0;
                if (next !=-1) {
                    p2 = v[index]+next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];

    }
}
