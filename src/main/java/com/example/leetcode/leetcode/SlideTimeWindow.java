package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SlideTimeWindow - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/19 16:21
 */
public class SlideTimeWindow {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(lengthOfLongestSubstring(s));

        findAnagrams(s, p);
    }

    // s = "abcabcbb" 输出 3
    // 3 无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.getOrDefault(s.charAt(i), 0) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 输出:
     * [["bat"],["nat","tan"],["ate","eat","tea"]] 示例 2:
     *
     * 输入: strs = [""] 输出: [[""]] 示例 3:
     *
     * 输入: strs = ["a"] 输出: [["a"]]
     */
    // 49 字母异位词分组
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String s = new String(chars);
            final List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(str);
            map.put(s, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    // 438. 找到字符串中所有字母异位词
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "cbaebabacd", p = "abc" 输出: [0,6] 解释: 起始索引等于 0 的子串是 "cba", 它是 "abc"
     * 的异位词。 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。 示例 2:
     *
     * 输入: s = "abab", p = "ab" 输出: [0,1,2] 解释: 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     *
     */

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return Collections.emptyList();
        }
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        int[] pa = new int[26];
        int[] sa = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pa[p.charAt(i) - 'a']++;
            sa[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sa, pa)) {
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sa[s.charAt(i)-'a']--;
            sa[s.charAt(i + p.length())-'a']++;
            if (Arrays.equals(sa, pa)) {
                result.add(i+1);
            }
        }
        return result;
    }

}
