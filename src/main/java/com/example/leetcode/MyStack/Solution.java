package com.example.leetcode.MyStack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        maxSlidingWindow(nums, k);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int len = nums.length;

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }

        int[] res = new int[len - k + 1];
        int num = 0;
        res[num] = myQueue.peek();
        for (int i = k; i < len; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[++num] = myQueue.peek();
        }
        return res;
    }


    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }
        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }
}
