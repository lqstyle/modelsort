package com.example.leetcode.leetcode.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * //给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * //
 * // candidates 中的每个数字在每个组合中只能使用 一次 。
 * //
 * // 注意：解集不能包含重复的组合。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * //输出:
 * //[
 * //[1,1,6],
 * //[1,2,5],
 * //[1,7],
 * //[2,6]
 * //]
 * //
 * // 示例 2:
 * //
 * //
 * //输入: candidates = [2,5,2,1,2], target = 5,
 * //输出:
 * //[
 * //[1,2,2],
 * //[5]
 * //]
 * //
 * //
 * //
 * // 提示:
 * //
 * //
 * // 1 <= candidates.length <= 100
 * // 1 <= candidates[i] <= 50
 * // 1 <= target <= 30
 * //
 * //
 * // Related Topics 数组 回溯 👍 1505 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * class Solution {
 * public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 * <p>
 * }
 * }
 * //leetcode submit region end(Prohibit modification and deletion)
 */
public class Combine40 {


    public static void main(String[] args) {
        int[] candidates = new int[]{1, 2, 2, 3};
        System.out.println(combinationSum2(candidates, 4));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used;
        int sum = 0;

        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(sum, candidates, target, 0, path, ans, used);
        return ans;
    }

    private static void backTracking(int sum, int[] candidates, int target, int startIndex, LinkedList<Integer> path, List<List<Integer>> ans, boolean[] used) {
        if (sum == target) {
            ans.add(new ArrayList(path));
            return;
        }
        //1, 2, 2, 3
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(sum, candidates, target, i + 1, path, ans, used);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
