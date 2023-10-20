package com.example.cdmodelsort;

import java.util.HashMap;
import java.util.Map;

/**
 * ArrayTest - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/19 16:02
 */

public class ArrayTest {

    /**
     * 1. 两数之和 提示 简单 17.8K 相关企业 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target
     * 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9 ，返回
     * [0, 1] 。
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }

            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     *
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     *
     * 示例 1：
     *
     * 输入：nums = [2,6,4,8,10,9,15] 输出：5 解释：你只需要对 [6, 4, 8, 10, 9]
     * 进行升序排序，那么整个表都会变为升序排序。 示例 2：
     *
     * 输入：nums = [1,2,3,4] 输出：0 示例 3：
     *
     * 输入：nums = [1] 输出：0
     *
     */

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 3, 3 };
        System.out.println(findUnsortedSubarray(nums));
    }
    // 581. 最短无序连续子数组
    // public static int findUnsortedSubarray(int[] nums) {
    // //初始化
    // int len = nums.length;
    // int min = nums[len-1];
    // int max = nums[0];
    // int begin = 0, end = -1;
    // //遍历
    // for(int i = 0; i < len; i++){
    // if(nums[i] < max){ //从左到右维持最大值，寻找右边界end
    // end = i;
    // }else{
    // max = nums[i];
    // }
    //
    // if(nums[len-i-1] > min){ //从右到左维持最小值，寻找左边界begin
    // begin = len-i-1;
    // }else{
    // min = nums[len-i-1];
    // }
    // }
    // return end-begin+1;
    // }

    public static int findUnsortedSubarray(int[] nums) {
        // 数组分成三段，寻找第一个小于最大值的节点 作为end 寻找右边第一个大于最小值的节点作为开始
        int begin = 0;
        int end = -1;
        int len = nums.length - 1;
        int r = len - 1;
        int max = nums[0];
        int min = nums[r];

        for (int i = 1; i < len; i++) {

            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];

            }

        }
        return end - begin + 1;
    }

}
