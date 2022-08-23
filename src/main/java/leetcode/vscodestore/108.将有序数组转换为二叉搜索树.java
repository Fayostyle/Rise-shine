/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {

        return traverse(nums, 0, nums.length-1);
        

    }

    public TreeNode traverse(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = traverse(nums, start, mid - 1);
        node.right = traverse(nums, mid+1, end);

        return node;

    }


    TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            // 区间为空
            return null;
        }
        // 构造根节点
        // BST 节点左小右大，中间的元素就是根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左子树
        root.left = build(nums, left, mid - 1);
        // 递归构造右子树
        root.right = build(nums, mid + 1, right);

        return root;
    }
}
// @lc code=end

