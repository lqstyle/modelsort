package com.example.leetcode.cdmodelsort.search;

import java.util.Objects;

/**
 * BinarySearch - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2022/12/20 19:17
 */
public class BinarySearch {

    public static void main(String[] args) {
        // int[] array = { 1, 2, 2, 4, 4, 5, 6, 7, 8, 9 };
        // System.out.println(getIndexViaBinarySearch(array, 2));
        // final int[] result = searchRange(array, 2);
        // for (int i : result) {
        // System.out.println(i);
        // }

        int[] num = new int[] { 10,9,2,5,3,7,101,18};
        lengthOfLIS(num);
    }

    public static int getIndexViaBinarySearch(int[] array, int target) {
        if (Objects.isNull(array)) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int i = 0;
        while (left < right) {
            System.out.println("查找次数: {}" + ++i);
            int middle = (left + right) >>> 1;
            if (target == array[middle]) {
                return middle;
            } else if (target > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == r ? new int[] { -1, -1 } : new int[] { l, r - 1 };
    }

    private static int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 287. 寻找重复数 中等 2.3K 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和
     * n），可知至少存在一个重复的整数。
     *
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     *
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 示例 1：
     *
     * 输入：nums = [1,3,4,2,2] 输出：2 示例 2：
     *
     * 输入：nums = [3,1,3,4,2] 输出：3
     *
     *
     * 提示：
     *
     * 1 <= n <= 105 nums.length == n + 1 1 <= nums[i] <= n nums 中 只有一个整数 出现 两次或多次
     * ，其余整数均只出现 一次
     *
     *
     * 进阶：
     *
     * 0->1 1->3 2->4 3->2 4->2 0->1->3->2->4->2 如何证明 nums 中至少存在一个重复的数字?
     * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
     */

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置 中等 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值
     * target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8 输出：[3,4] 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6 输出：[-1,-1] 示例 3：
     *
     * 输入：nums = [], target = 0 输出：[-1,-1]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105 -109 <= nums[i] <= 109 nums 是一个非递减数组 -109 <= target
     * <= 109
     */

    public static int[] searchRange1(int[] nums, int target) {
        // 寻找最左边的位置

        int l = search1(nums, target);
        // 寻找最右边的位置
        int r = search1(nums, target + 1);

        return l == r ? new int[] { -1, -1 } : new int[] { l, r - 1 };

    }

    public static int search1(int[] nums, int n) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] >= n) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * HashMap是Java中常用的数据结构，它基于哈希表实现。哈希表是一种以键-值（key-value）对存储数据的数据结构，它的特点是可以快速插入、删除和查找数据。
     *
     * HashMap的底层实现主要由数组和链表两部分组成。数组存储哈希桶，每个桶中存储的是一个链表的头节点。当发生哈希冲突时，会将新的键值对插入到链表的末尾。
     *
     * HashMap的put方法的实现过程如下：
     *
     * 计算键的哈希值，使用哈希函数将哈希值映射到数组的索引位置。
     *
     * 检查该索引位置是否已经有值，如果没有值，则将新的键值对插入到该位置。
     *
     * 如果该索引位置已经有值，则遍历该位置的链表，查找是否存在相同的键。如果找到相同的键，则更新该键对应的值；否则将新的键值对插入到链表的末尾。
     *
     * 如果链表长度超过了阈值（默认为8），则将链表转化为红黑树，以提高查找效率。
     *
     * 如果数组大小超过了阈值（默认为64），则将数组扩容为原来的两倍，并重新计算每个键的哈希值和索引位置。
     *
     * HashMap的get方法的实现过程如下：
     *
     * 计算键的哈希值，使用哈希函数将哈希值映射到数组的索引位置。
     *
     * 查找该索引位置是否有值，如果没有值，则返回null。
     *
     * 如果该索引位置有值，则遍历该位置的链表或红黑树，查找是否存在相同的键。如果找到相同的键，则返回对应的值；否则返回null。
     *
     * HashMap的底层实现涉及到的算法包括哈希函数、哈希冲突处理、链表和红黑树等数据结构的实现。正确的使用和理解HashMap底层原理可以帮助我们更好地理解Java中的数据结构和算法。
     */

    /**
     * 300. 最长递增子序列
     * 中等
     * 3.4K
     * 相关企业
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     */

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];

        int result = 1;

        dp[0]=1;
        for (int i = 1; i < len; i++) {
            dp[i]=1;

            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(dp[i],result);
        }
        return result;

    }
}
