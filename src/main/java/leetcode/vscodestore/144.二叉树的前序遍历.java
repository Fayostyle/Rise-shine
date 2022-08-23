/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // if(root == null) {
        //     return Collections.emptyList();
        // }
        // List<Integer> res = new LinkedList<>();
        // res.add(root.val);
        // res.addAll(preorderTraversal(root.left));
        // res.addAll(preorderTraversal(root.right));

        // return res;
        
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

