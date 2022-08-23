/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    //方案1========
    // int res = Integer.MIN_VALUE;
    // int depth = 0;
    // public int maxDepth(TreeNode root) {
    //     traverse(root);
    //     return res;

    // }

    // public void traverse(TreeNode node) {
    //     if(node == null) {
    //         res = Math.max(res, depth);
    //         return;
    //     }

    //     depth++;
    //     traverse(node.left);
    //     traverse(node.right);
    //     depth--;

    // }

    //方案2================
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;

    }

    
}
// @lc code=end

