package com.example.cdmodelsort.search;

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
        int[] array = { 1, 2, 2, 4, 4, 5, 6, 7, 8, 9 };
        System.out.println(getIndexViaBinarySearch(array, 2));
        final int[] result = searchRange(array, 2);
        for (int i : result) {
            System.out.println(i);
        }
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

}
