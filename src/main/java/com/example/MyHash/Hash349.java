package com.example.MyHash;

import java.util.*;

/**
 * //给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * //输出：[2]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * //输出：[9,4]
 * //解释：[4,9] 也是可通过的
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums1.length, nums2.length <= 1000
 * // 0 <= nums1[i], nums2[i] <= 1000
 * //
 * //
 * // Related Topics 数组 哈希表 双指针 二分查找 排序 👍 878 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * class Solution {
 * public int[] intersection(int[] nums1, int[] nums2) {
 * <p>
 * }
 * }
 * //leetcode submit region end(Prohibit modification and deletion)
 *
 * 查找数组交集
 */
public class Hash349 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{9, 4, 9, 8, 4};
        int[] nums2 = new int[]{4, 9, 5};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                result.add(n);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}
