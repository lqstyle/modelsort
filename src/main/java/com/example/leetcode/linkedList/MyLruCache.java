package com.example.leetcode.linkedList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MyLruCache - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/10/16 17:35
 */
public class MyLruCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public MyLruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
