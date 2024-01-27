package com.example.leetcode.linkedList;

// 19 删除链表的倒数第n个节点
public class List19 extends ListNode {

/**
 d->1->2->3->4
 若删除倒数第二个元素
 fast 和slow同时初始化到d
 当   fast走2步  到达节点2
     fast再走两步到达4
    slow到达2  此时3就是要删除的元素

 */




    List19(int x) {
        super(x);
    }

    //快慢指针 快慢指针同时指向哨兵节点，快指针先走n步，当快指针走到尾部的时候，慢指针就指向了要删除节点的前一个
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next!= null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
