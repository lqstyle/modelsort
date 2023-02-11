package com.example.cdmodelsort.tree;

import java.util.ArrayDeque;

import com.example.cdmodelsort.tree.RecursionTree.TreeNode;

/**
 * NotRecursionTree - 非递归遍历
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/17 11:18
 */
public class NotRecursionTree {

    public static void main(String[] args) {
        final TreeNode treeNode = RecursionTree.buildTree();
        // 深度优先遍历->中序遍历   根右左  栈实现
        noRecursionTree(treeNode); // 1243
        // 深度优先遍历->后续遍历  两个栈  根左右  栈实现
        noRecursionPostTree(treeNode); // 4231
        // 深度优先遍历->中序遍历  先遍历左孩子，若左孩子为空，后遍历右孩子的左孩子  栈实现
        noRecursionMiddleTree(treeNode); // 4213
        // 广度优先遍历 队列实现
        noRecusionWidthTree(treeNode);
    }

    private static void noRecusionWidthTree(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>() ;
        queue.add(treeNode);
        while(!queue.isEmpty()){
            TreeNode tmp =  queue.poll();
            System.out.println(tmp.val);
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }
    }

    /**
     * 先序遍历 非递归方式实现，首节点入栈，然后出栈，然后弹入该节点的右节点， 左节点，出栈 如此循环
     * 
     * @param treeNode
     */
    private static void noRecursionTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        // 首节点入栈
        arrayDeque.push(treeNode);

        while (!arrayDeque.isEmpty()) {
            // 出栈
            final TreeNode treeNode1 = arrayDeque.pop();
            System.out.println(treeNode1.val);
            // 压入当前节点的右节点
            if (treeNode1.right != null) {
                arrayDeque.push(treeNode1.right);
            }
            // 压入当前节点的左节点
            if (treeNode1.left != null) {
                arrayDeque.push(treeNode1.left);
            }
        }

    }

    /**
     * 后序遍历 非递归方式实现 利用两个栈，一个栈用户存储数据，栈2，一个栈用于入栈出栈 栈1 首节点分别入栈 栈1 和栈2
     * 弹出栈1节点，先写入栈1弹出节点的左节点，再写入栈1弹出的节点的右节点，如此往复
     *
     * @param treeNode
     */
    private static void noRecursionPostTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        ArrayDeque<TreeNode> arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> arrayDeque2 = new ArrayDeque<>();
        // 首节点入栈
        arrayDeque1.push(treeNode);

        while (!arrayDeque1.isEmpty()) {
            // 出栈
            final TreeNode treeNode1 = arrayDeque1.pop();
            arrayDeque2.push(treeNode1);
            // 压入当前节点的左节点
            if (treeNode1.left != null) {
                arrayDeque1.push(treeNode1.left);
            }
            // 压入当前节点的右节点
            if (treeNode1.right != null) {
                arrayDeque1.push(treeNode1.right);
            }
        }
        while (!arrayDeque2.isEmpty()) {
            System.out.println(arrayDeque2.pop().val);
        }
    }

    /**
     * 中序遍历 非递归方式实现
     *
     * @param treeNode
     */
    private static void noRecursionMiddleTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        ArrayDeque<TreeNode> arrayDeque1 = new ArrayDeque<>();

        while (!arrayDeque1.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                // 左树遍历
                arrayDeque1.push(treeNode);
                treeNode = treeNode.left;
            } else {
                // 左树为空，从赋值右树并继续遍历左树
                TreeNode temp = arrayDeque1.pop();
                System.out.println(temp.val);
                treeNode = temp.right;
            }
        }
    }
}
