package com.example.leetcode.leetcode.combine;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;

/**
 * Combine - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/17 16:59
 */
public class Combine {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target
     * 的 所有 不同组合 ，并以列表形式返回。 你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7 输出：[[2,2,3],[7]] 解释： 2 和 3 可以形成一组候选，2 +
     * 2 + 3 = 7 。注意 2 可以使用多次。 7 也是一个候选， 7 = 7 。 仅有这两种组合。 示例 2：
     *
     * 输入: candidates = [2,3,5], target = 8 输出: [[2,2,2,2],[2,3,3],[3,5]] 示例 3：
     *
     * 输入: candidates = [2], target = 1 输出: []
     *
     * 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
     * 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
     *
     * 
     */

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 5 };
        System.out.println(combinationSum(nums,8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, path, 0, target, candidates);
        return res;
    }

    public static void dfs(List<List<Integer>> list, List<Integer> path, int index, int target, int[] candidates) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(list, path, i, target - candidates[i], candidates);
            path.remove(path.size() - 1);
        }
    }

    // 46 全排列
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<>(nums.length);
        if (len == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];

        dfs(result, path, 0, nums, len, used);
        return result;
    }

    public static void dfs(List<List<Integer>> list, Deque<Integer> path, int index, int[] nums, int len,
            boolean[] used) {
        if (index == len) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(list, path, index + 1, nums, len, used);
            path.removeLast();
            used[i] = false;
        }
    }

    // 电话号码的字母组合

    public static List<String> letterCombinations(String digits) {
        if (StringUtils.isEmpty(digits)) {
            return new ArrayList<>();
        }
        Map<Character, String> dict = new HashMap<Character, String>();
        dict.put('1', "");
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        List<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        final char[] chars = digits.toCharArray();
        dfs(list, dict, chars, 0, chars.length, stringBuilder);
        return list;
    }

    public static void dfs(List<String> list, Map<Character, String> dict, char[] chars, int index, int len,
            StringBuilder stringBuilder) {
        if (index == len) {
            list.add(stringBuilder.toString());
            return;
        }

        char digit =chars[index];
        String letters = dict.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            stringBuilder.append(letters.charAt(i));
            dfs(list, dict, chars, index + 1, len, stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
//        for (int i =0; i < len; i++) {
//            final String s = dict.get(chars[i]);
//            final char[] chars1 = s.toCharArray();
//            for (char c : chars1) {
//                stringBuilder.append(c);
//                dfs(list, dict, chars, index + 1, len, stringBuilder);
//                stringBuilder.deleteCharAt(stringBuilder.length()-1);
//            }
        }

}
