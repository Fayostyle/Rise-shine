/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    TreeNode res = new TreeNode(-1);

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;

        root.right = root.left;
        root.left = null;
        
        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }

        p.right = tmp;

    
    }

    

    // List<TreeNode> list = new LinkedList<>();


    // public void flatten(TreeNode root) {
    //     build(root);
    //     TreeNode p = res;
    //     for(TreeNode node : list) {
    //         p.right = node;
    //         p.left = null;
    //         p = p.right;
    //     }
        
    // }
    // public void build(TreeNode root) {
    //     if(root == null) return;
        
    //     list.add(root);

    //     build(root.left);
    //     build(root.right);
        
    // }

}
// @lc code=end

