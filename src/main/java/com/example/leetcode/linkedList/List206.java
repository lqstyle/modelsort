package com.example.leetcode.linkedList;

public class List206 extends ListNode {

    public List206(int x) {
        super(x);
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}


