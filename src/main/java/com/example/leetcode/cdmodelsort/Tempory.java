package com.example.leetcode.cdmodelsort;

import java.util.Deque;
import java.util.LinkedList;

public class Tempory {

    public static void main(String[] args) {
        int[] te = {30,40,50,60};
        int[] ints = dailyTemperatures(te);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
        public static int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> deque=new LinkedList<Integer>();
            int[] res=new int[temperatures.length];
            for(int i=0;i<temperatures.length;i++){
                int num=temperatures[i];
                while(!deque.isEmpty()&&num>temperatures[deque.peek()]){
                    int index=deque.pop();
                    res[index]=i-index;
                }
                deque.push(i);
            }
            return res;
        }
}
