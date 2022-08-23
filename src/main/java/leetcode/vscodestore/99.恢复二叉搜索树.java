/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode first = null, second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);

        int tmp;
        tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inorderTraversal(TreeNode root) {
        if(root == null) return;

        inorderTraversal(root.left);

        if(root.val < prev.val) {
            if(first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        inorderTraversal(root.right);
    }
}
// @lc code=end


