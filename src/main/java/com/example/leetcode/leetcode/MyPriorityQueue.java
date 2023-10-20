package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * MyPriorityQueue - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/19 20:24
 */
public class MyPriorityQueue {

    public static void main(String[] args) {
//        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
//        int k = 2;
//        System.out.println(topKFrequent(nums, k));
//
//        int[] nums = new int[] { 5, 3, 2, 1, 7, 9 };
//        int k = 2;
//        System.out.println(findKthLargest(nums, k));

        List<Student>  list = new ArrayList<>();
        Student student = new Student(1,"1");
        Student student2 = new Student(2,"2");
        TreeMap<Integer,Student> tree = new TreeMap<>((o1, o2) -> o2.intValue()-o1.intValue());
        list.stream().filter(t->t.getAge()==1).collect(Collectors.toList());
        tree.put(student.getAge(),student);
        tree.put(student2.getAge(),student2);
        System.out.println(tree);
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        int result = -1;
        for (int i = 0; i < k; i++) {
            if (heap.isEmpty()) {
                break;
            }
            result = heap.poll();
        }
        return result;
    }

    // 347. 前 K 个高频元素
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->map.get(o1)-map.get(o2));

        final Set<Integer> set = map.keySet();
        for(int key : set){
            if(heap.size()<k){
                heap.offer(key);
            }else if(map.get(key)>map.get(heap.peek())){
                heap.remove();
                heap.offer(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Student  implements  Comparator<Student>{
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge()-o2.getAge();
        }
    }
}
