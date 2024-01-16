package com.example.leetcode.linkedList;

/**
 * public ListNode removeElements(ListNode head, int val) {
 * <p>
 * }
 * <p>
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * <p>
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * <p>
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class List203 extends ListNode {

    public List203(int x) {
        super(x);
    }

    // 移除链表元素
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }

            cur = cur.next;
        }
        return dummy.next;
    }


}
