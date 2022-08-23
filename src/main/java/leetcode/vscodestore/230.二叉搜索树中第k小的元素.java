/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    int rank = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        kthSmallest(root.left, k);
        rank++;
        if(rank == k) {
            res =  root.val;
            return res;
        }
        
        kthSmallest(root.right, k);    
        return res;

    }

}
// @lc code=end

