package com.example.leetcode.MyQueue;

import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//347 前k个高频元素
public class MyQueue {

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,3,1,1,2};
        int k =2;
        topKFrequent(nums,k);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);

        for (Map.Entry<Integer, Integer> mapTemp : map.entrySet()) {
            queue.offer(new int[]{mapTemp.getKey(), mapTemp.getValue()});
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}
