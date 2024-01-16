package com.example.leetcode.linkedList;

/**
 * //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：head = [1,2,3,4]
 * //输出：[2,1,4,3]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：head = []
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：head = [1]
 * //输出：[1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 链表中节点的数目在范围 [0, 100] 内
 * // 0 <= Node.val <= 100
 * //
 * //
 * // Related Topics 递归 链表 👍 2128 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 */
public class List24 extends ListNode {

    // 两两交换链表中的节点
    List24(int x) {
        super(x);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        ListNode tmp ;

        while (cur.next != null && cur.next.next != null) {
            // 获取第三个节点 因为已经判断了后两个不为空，不管第三个是否可以为空，都可以获取到
            tmp = cur.next.next.next;
            // 获取第一个节点 此处是头结点 此处为引用
            ListNode node1 = cur.next;
            //获取第二个节点   此处为引用
            ListNode node2 = cur.next.next;

            // 开始移动

            //哨兵节点指向反转后的头结点 保证新链表节点的获取
            cur.next=node2;
            // 第二个节点的指针指向第一个节点，老的头结点
            node2.next=node1;
            // 第一个节点（老的头结点）的指针指向第三个节点
            node1.next = tmp;
            // 辅助节点需要指向第一个节点 即新的哨兵节点，便于后续遍历
            cur=node1;
        }
        return dummy.next;
    }

}
