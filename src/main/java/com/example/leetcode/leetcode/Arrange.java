package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,2,3]
 * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,1]
 * //输出：[[0,1],[1,0]]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [1]
 * //输出：[[1]]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 6
 * // -10 <= nums[i] <= 10
 * // nums 中的所有整数 互不相同
 * //
 * //
 * // Related Topics 数组 回溯 👍 2792 👎 0
 */
public class Arrange {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, deque, nums, used, nums.length);
        return res;
    }

    public static void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums, boolean[] used, int length) {

        if (deque.size() == length) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < length; i++) {

            if (used[i]) {
                continue;
            }
            used[i] = true;
            deque.addLast(nums[i]);

            dfs(res, deque, nums, used, length);

            deque.removeLast();
            used[i] = false;
        }

    }
}
