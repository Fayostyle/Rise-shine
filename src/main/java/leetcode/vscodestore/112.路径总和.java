/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        /**
            bfs 广度优先遍历
         */
         
    //  if(root == null) return false;

    //     Queue<TreeNode> nodeQueue = new LinkedList<>();
    //     Queue<Integer> valQueue = new LinkedList<>();

    //     nodeQueue.offer(root);
    //     valQueue.offer(root.val);

    //     while(!nodeQueue.isEmpty()) {
    //         TreeNode curr = nodeQueue.poll();
    //         int currVal = valQueue.poll();
    //         if(curr.left == null && curr.right == null && currVal == targetSum){
    //             return true;
    //         }

    //         if(curr.left != null) {
    //             nodeQueue.offer(curr.left);
    //             valQueue.offer(curr.left.val + currVal);
    //         }

    //         if(curr.right != null) {
    //             nodeQueue.offer(curr.right);
    //             valQueue.offer(curr.right.val + currVal);
    //         }

    //     }
    //     return false;
        
    // }


    /**
        递归
     */
    //  if(root == null) return false;
    //  if(root.left == null && root.right == null && root.val == targetSum) {
    //      return true;
    //  }

    //  return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    // }

    /**
        回溯遍历每一个节点
     */
    
    this.sum = targetSum;
    traverse(root);
    return found;
    
    }
    int sum;
    boolean found = false;
    int curVal = 0;
    public void traverse(TreeNode root) {
        if(root == null) return;

        curVal += root.val;

        if(root.left == root.right && curVal == sum) {
            found = true;
        }

        traverse(root.left);
        traverse(root.right);

        curVal -= root.val;
    }

}
// @lc code=end

