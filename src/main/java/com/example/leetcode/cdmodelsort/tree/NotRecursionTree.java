package com.example.leetcode.cdmodelsort.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

/**
 * NotRecursionTree - 非递归遍历
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/1/17 11:18
 */
public class NotRecursionTree {

    public static void main(String[] args) {
        final TreeNode treeNode = buildTree();
        // 深度优先遍历->先序遍历 根右左 栈实现
        noRecursionTree(treeNode); // 1243
        noRecursionPreTree(treeNode);
        // 深度优先遍历->后续遍历 两个栈 根左右 栈实现
        noRecursionPostTree(treeNode); // 4231
        noRecursionPostTreeBak(treeNode);
        // 深度优先遍历->中序遍历 先遍历左孩子，若左孩子为空，后遍历右孩子的左孩子 栈实现
        noRecursionMiddleTree(treeNode); // 4213
        noRecursionMiddleTreeBak(treeNode); // 4213
        // 广度优先遍历 队列实现
        noRecusionWidthTree(treeNode);
    }

    private static void noRecusionWidthTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    //102 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list= new ArrayList<>();
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode poll = queue.poll();
                assert poll != null;
                list.add(poll.val);
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }


        return result;
    }

    //337 打家劫舍

    /**
     * 在解法一和解法二中，我们使用爷爷、两个孩子、4 个孙子来说明问题 首先来定义这个问题的状态 爷爷节点获取到最大的偷取的钱数呢
     *
     * 首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
     * 二叉树只有左右两个孩子，一个爷爷最多 2 个儿子，4 个孙子
     * 根据以上条件，我们可以得出单个节点的钱该怎么算 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，
     * 就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构

     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }

        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }


    public int robBak(TreeNode root) {
        if(root==null){
            return 0;
        }
        int money = root.val;
        if(root.left!=null){
            money+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            money+=rob(root.right.left)+rob(root.right.right);
        }

        return Math.max(money,rob(root.left)+rob(root.right));
    }

    public int robInterel(TreeNode root, HashMap<TreeNode,Integer> cache) {
        if(root==null){
            return 0;
        }
        if(cache.containsKey(root)){
            return cache.get(root);
        }
        int money = root.val;
        if(root.left!=null){
            money+=robInterel(root.left.left,cache)+robInterel(root.left.right,cache);
        }
        if(root.right!=null){
            money+=robInterel(root.right.left,cache)+robInterel(root.right.right,cache);
        }

        final int max = Math.max(money, robInterel(root.left,cache) + robInterel(root.right,cache));
        cache.put(root,max);
        return max;
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

    private static void noRecursionPreTree(TreeNode treeNode) {
        if(treeNode ==null){
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(treeNode);

        while(!deque.isEmpty()){
            final TreeNode pop = deque.pop();
            System.out.println(pop.val);
            if(pop.right!=null){
                deque.push(pop.right);
            }
            if(pop.left!=null){
                deque.push(pop.left);
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

    private static void noRecursionPostTreeBak(TreeNode treeNode) {
        if(treeNode==null){
            return;
        }
        Deque<TreeNode> dequeTmp  = new ArrayDeque<>();
        Deque<TreeNode> deque  = new ArrayDeque<>();
        dequeTmp.push(treeNode);

        while(!dequeTmp.isEmpty()){

            final TreeNode tree = dequeTmp.pop();
            deque.push(tree);

            if(tree.left!=null){
                dequeTmp.push(tree.left);
            }
            if(tree.right!=null){
                dequeTmp.push(tree.right);
            }
        }
        while(!deque.isEmpty()){
            System.out.println(deque.pop().val);
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

    private static void noRecursionMiddleTreeBak(TreeNode treeNode) {
        if(treeNode==null){
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();

        while(!deque.isEmpty() || treeNode!=null){
            if(treeNode!=null){
                deque.push(treeNode);
                treeNode=treeNode.left;
            }else{
                final TreeNode popTree = deque.pop();
                System.out.println(popTree.val);
                treeNode = popTree.right;
            }
        }
    }
    static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        return treeNode;
    }
}
