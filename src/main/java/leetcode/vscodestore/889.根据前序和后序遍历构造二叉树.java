/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd) {
            return null;
        }

        if(preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int leftRootVal = preorder[preStart  + 1];
        int index = 0;
        for(int i=postStart; i<postEnd; i++) {
            if(postorder[i] == leftRootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - postStart + 1;

        root.left = build(preorder, preStart+1, preStart+leftSize, postorder, postStart, postStart+leftSize-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd, postorder, postStart+leftSize, postEnd-1);
        return root;


    }
}
// @lc code=end

