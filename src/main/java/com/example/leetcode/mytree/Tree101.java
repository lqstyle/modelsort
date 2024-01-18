package com.example.leetcode.mytree;

/**
 * //给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：root = [1,2,2,3,4,4,3]
 * //输出：true
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：root = [1,2,2,null,3,null,3]
 * //输出：false
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 树中节点数目在范围 [1, 1000] 内
 * // -100 <= Node.val <= 100
 * //
 * //
 * //
 * //
 * // 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * //
 * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2630 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * /**
 * * Definition for a binary tree node.
 * * public class TreeNode {
 * *     int val;
 * *     TreeNode left;
 * *     TreeNode right;
 * *     TreeNode() {}
 * *     TreeNode(int val) { this.val = val; }
 * *     TreeNode(int val, TreeNode left, TreeNode right) {
 * *         this.val = val;
 * *         this.left = left;
 * *         this.right = right;
 * *     }
 * * }
 */
public class Tree101 extends TreeNode {

    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode treeNode1, TreeNode treeNode2) {

        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }

        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        if (treeNode1.val == treeNode2.val) {
            return true;
        }

        return dfs(treeNode1.left, treeNode2.right) && dfs(treeNode1.right, treeNode2.left);
    }
}
