package com.example.leetcode.leetcode.combine;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * //
 * // 你可以按 任何顺序 返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 4, k = 2
 * //输出：
 * //[
 * //  [2,4],
 * //  [3,4],
 * //  [2,3],
 * //  [1,2],
 * //  [1,3],
 * //  [1,4],
 * //]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 1, k = 1
 * //输出：[[1]]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 20
 * // 1 <= k <= n
 */
public class Combine77 {


    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        int begin = 1;

        backTracing(res, deque, k, n, begin);

        return res;

    }

    public static void backTracing(List<List<Integer>> res, Deque<Integer> deque, int k, int n, int begin) {
        if (deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i <= n; i++) {
            deque.addLast(i);
            backTracing(res, deque, k, n, i + 1);
            deque.removeLast();
        }
    }
}
