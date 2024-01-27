package com.example.MyHash;

/**
 * //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * //
 * // 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: s = "anagram", t = "nagaram"
 * //输出: true
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: s = "rat", t = "car"
 * //输出: false
 * //
 * //
 * //
 * // 提示:
 * //
 * //
 * // 1 <= s.length, t.length <= 5 * 10⁴
 * // s 和 t 仅包含小写字母
 * //
 * //
 * //
 * //
 * // 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * //
 * // Related Topics 哈希表 字符串 排序 👍 886 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * class Solution {
 * <p>
 * <p>
 * <p>
 * }
 * //leetcode submit region end(Prohibit modification and deletion)
 *
 * 字母异位词
 */
public class Hash242 {


    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }

        int[] characters = new int[26];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            characters[c - 'a']++;
        }

        char[] charArrayT = t.toCharArray();
        for (char c : charArrayT) {
            characters[c - 'a']--;
        }

        for (int character : characters) {
            if (character != 0) {
                return false;
            }
        }
        return true;
    }
}
